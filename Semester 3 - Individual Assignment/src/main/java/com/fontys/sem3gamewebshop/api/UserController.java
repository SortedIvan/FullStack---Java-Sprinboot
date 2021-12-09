package com.fontys.sem3gamewebshop.api;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fontys.sem3gamewebshop.model.AppUser;
import com.fontys.sem3gamewebshop.model.Role;
import com.fontys.sem3gamewebshop.service.IUserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.util.*;
import java.util.stream.Collectors;


import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController @RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    private final IUserService iUserService;

    @Autowired
    public UserController(IUserService iUserService){
        this.iUserService = iUserService;
    }

    @GetMapping("/user/email/{email}")
    public ResponseEntity<AppUser> getUserByEmail(@PathVariable("email") String email){
        return ResponseEntity.ok().body(iUserService.findUserByEmail(email));
    }
    @GetMapping("/user/username/{username}")
    public ResponseEntity<AppUser> getUser(@PathVariable("username") String username){
        return ResponseEntity.ok().body(iUserService.getUser(username));
    }


    @PutMapping("/user/edit")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_GAMEDEV') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<AppUser> editUser(@RequestBody AppUser appUser){
        if(this.iUserService.editUser(appUser)){
            return ResponseEntity.ok().build();
        }
        else{
            return new ResponseEntity("Please provide a valid username", HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/users")
    public ResponseEntity<List<AppUser>> getUsers(){
        return ResponseEntity.ok().body(iUserService.getUsers());
    }

    @PostMapping("/register")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<AppUser> saveUsers(@RequestBody AppUser user){
        if(user == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);

        }else{
            iUserService.saveUser(user);
            iUserService.addRoleToUser(user.getUsername(), "ROLE_USER");
            return ResponseEntity.ok().build();
        }
    }

    @PostMapping("/role/save")
    public ResponseEntity<Role> saveRole(@RequestBody Role role){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/save").toUriString());
        return ResponseEntity.created(uri).body(iUserService.saveRole(role));
    }
    @PostMapping("/user/changepassword")
    public ResponseEntity<String> changeUserPassword(@RequestBody ChangePassword changePassword){
        iUserService.changeUserPassword(changePassword.getUsername(),changePassword.getOldPassword(),changePassword.getNewPassword());
        return ResponseEntity.ok().body("Password changed succesfully");
    }

    @PostMapping("/role/addtouser")
    public ResponseEntity<?> addRoleToUser(@RequestBody RoleToUserForm form){
        iUserService.addRoleToUser(form.getUsername(),form.getRoleName());
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/user/delete/{id}")
    public ResponseEntity<?> deleteUserByUsername(@PathVariable("id") Long id){
        iUserService.deleteUser(id);
        return ResponseEntity.ok().build();
    }


    @GetMapping("/token/refresh")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String authorizationHeader = request.getHeader(AUTHORIZATION);
        if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ")){
            try{
                String refresh_token = authorizationHeader.substring("Bearer ".length());
                Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
                JWTVerifier verifier = JWT.require(algorithm).build();
                DecodedJWT decodedJWT = verifier.verify(refresh_token);
                String username = decodedJWT.getSubject();
                AppUser user = iUserService.getUser(username);
                String access_token = JWT.create()
                        .withSubject(user.getUsername())
                        .withExpiresAt(new Date(System.currentTimeMillis() + 10 * 60 * 1000))
                        .withIssuer(request.getRequestURL().toString())
                        .withClaim("roles", user.getRoles().stream().map(Role:: getName).collect(Collectors.toList()))
                        .sign(algorithm);
                Map<String, String> tokens = new HashMap<>();
                tokens.put("access_token", access_token);
                tokens.put("refresh_token", refresh_token);
                response.setContentType(APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), tokens);
            }
            catch(Exception exception){

                response.setHeader("error", exception.getMessage());
                response.setStatus(FORBIDDEN.value());
                //response.sendError(FORBIDDEN.value());
                Map<String, String> error = new HashMap<>();
                error.put("error_message", exception.getMessage());

                response.setContentType(APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), error);







            }

        } else {
            throw new RuntimeException("Refresh token is missing");
        }
    }




}


@Data
class RoleToUserForm{
    private String username;
    private String roleName;
}

@Data
class ChangePassword{
    private String username;
    private String oldPassword;
    private String newPassword;
}
