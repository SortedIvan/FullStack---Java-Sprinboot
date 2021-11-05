package com.fontys.sem3gamewebshop;


import com.fontys.sem3gamewebshop.dal.IAppUserDAL;
import com.fontys.sem3gamewebshop.model.AppUser;
import com.fontys.sem3gamewebshop.model.Role;
import com.fontys.sem3gamewebshop.service.UserService;
import org.h2.engine.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.mockito.Mockito.*;

@ActiveProfiles("test")
@SpringBootTest
public class AppUserServiceMockTest {
    @Mock
    IAppUserDAL appUserDAL;
    @Mock
    PasswordEncoder passwordEncoder;


    @BeforeEach
    public void setUp(){
        List<Role> roles = List.of(
                new Role(null,"ROLE_USER"),
                new Role(null,"ROLE_GAMEDEV"),
                new Role(null,"ROLE_ADMIN")

        );

        List<AppUser> appUserList = List.of(
                new AppUser(null, "Ivan Ovcharov", "ivan2e","ivan888@gmail.com", "12345", new ArrayList<>(), new ArrayList<>()),
                new AppUser(null, "Hamako Yutai", "hamako","tom123@gmail.com", "12345", new ArrayList<>(), new ArrayList<>()),
                new AppUser(null, "Boriz Tunai", "boriz1","boriz@gmail.com", "12345", new ArrayList<>(), new ArrayList<>()),
                new AppUser(null, "Ivan Test", "ivantest", "ivan@gmail.com", "12345", new ArrayList<>(), new ArrayList<>())
        );
        AppUser appUserTest = new AppUser(null, "Ivan Ovcharov", "ivan2e","ivan888@gmail.com", "12345", new ArrayList<>(), new ArrayList<>());
        appUserDAL.addRoleToUser("ivan2e", "ROLE_USER");
        appUserDAL.addRoleToUser("hamako", "ROLE_GAMEDEV");
        appUserDAL.addRoleToUser("boriz1", "ROLE_ADMIN");
        appUserDAL.addRoleToUser("boriz1", "ROLE_GAMEDEV");
        appUserDAL.addRoleToUser("boriz1", "ROLE_USER");
        appUserDAL.addRoleToUser("ivantest", "ROLE_ADMIN");

        when(appUserDAL.getUsers()).thenReturn(appUserList);
        when(appUserDAL.findUserByEmail("ivan888@gmail.com")).thenReturn(appUserTest);
        when(appUserDAL.getUser("ivan2e")).thenReturn(appUserTest);



    }

    @Test
    public void getAllUsers(){
        UserService userService = new UserService(appUserDAL,passwordEncoder);

        List<AppUser> users = userService.getUsers();
        Assertions.assertEquals(users.get(0).getUsername(), "ivan2e");
        Assertions.assertEquals(users.get(1).getUsername(), "hamako");
        Assertions.assertEquals(users.get(2).getUsername(), "boriz1");
        Assertions.assertEquals(users.get(3).getUsername(), "ivantest");

    }

    @Test
    @Disabled
    public void getUserById(){
        UserService userService = new UserService(appUserDAL,passwordEncoder);
        List<AppUser> users = userService.getUsers();
        AppUser user = userService.findUserById(4L).get();
        Assertions.assertEquals(users.get(0).getId(), 4L);
    }

    @Test
    public void getUserRoles(){
        UserService userService = new UserService(appUserDAL,passwordEncoder);
        List<AppUser> users = userService.getUsers();
        users.get(0).getRoles().add(new Role(null,"ROLE_USER"));
        users.get(0).getRoles().add(new Role(null,"ROLE_GAMEDEV"));
        users.get(0).getRoles().add(new Role(null,"ROLE_ADMIN"));

        List<Role> roles = List.of(
                new Role(null,"ROLE_USER"),
                new Role(null,"ROLE_GAMEDEV"),
                new Role(null,"ROLE_ADMIN")

        );
        Assertions.assertEquals(users.get(0).getRoles(), roles);

    }

    @Test
    public void getUserByEmail(){
        UserService userService = new UserService(appUserDAL,passwordEncoder);
        AppUser appUserTest = userService.findUserByEmail("ivan888@gmail.com");
        Assertions.assertEquals(appUserTest.getUsername(), "ivan2e");

    }

    @Test
    public void saveUser(){
        UserService userService = new UserService(appUserDAL, passwordEncoder);
        AppUser appUser = new AppUser(null, "Testing Ovcharov", "ivan2e","testing@gmail.com", "testing", new ArrayList<>(), new ArrayList<>());
        userService.saveUser(appUser);
        ArgumentCaptor<AppUser> appUserArgumentCaptor = ArgumentCaptor.forClass(AppUser.class);
        verify(appUserDAL).saveUser(appUserArgumentCaptor.capture());
        AppUser captureUser = appUserArgumentCaptor.getValue();
        Assertions.assertEquals(appUser.getUsername(),captureUser.getUsername());

    }
    @Test
    public void addRoleToUser(){
        UserService userService = new UserService(appUserDAL, passwordEncoder);
        List<AppUser> users = userService.getUsers();
        Role role = new Role(null, "TEST_ROLE");
        users.get(0).getRoles().add(role);
        userService.saveRole(role);
        List<Role> roles = List.of(
                new Role(null, "TEST_ROLE")
        );
        userService.addRoleToUser("ivan2e", "TEST_ROLE");
        Assertions.assertEquals(users.get(0).getRoles(),roles);
    }

    @Test
    public void changeUserPassword(){
        UserService userService = new UserService(appUserDAL, passwordEncoder);
        List<AppUser> users = userService.getUsers();
        AppUser appUser = userService.getUser("ivan2e");
        userService.changeUserPassword("ivan2e", "testpassword" , "12345");
        Assertions.assertEquals(appUser.getPassword(), "12345");

    }


    //CTRL + ALT + S --- BUILD ---- RUN TESTS & ... using gradle!!!!!
}
