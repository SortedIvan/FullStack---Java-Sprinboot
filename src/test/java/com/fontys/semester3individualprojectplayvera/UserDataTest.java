package com.fontys.semester3individualprojectplayvera;

import com.fontys.semester3individualprojectplayvera.Service.UserService;
import com.fontys.semester3individualprojectplayvera.model.User;
import com.fontys.semester3individualprojectplayvera.repository.FakeDataStore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class UserDataTest {

    @Test
    public void GetAllUsers_getAllUsersTest() {
        UserService userService = new UserService(new FakeDataStore());
        List<User> expectedUsers = userService.GetAllUsers();
        Assertions.assertNotNull(expectedUsers);

    }

    @Test
    public void GetUserByUsername_getUserByUsernameTest(){
        UserService userService = new UserService(new FakeDataStore());
        User user = userService.GetUserByUsername("vionev");

        Assertions.assertNotNull(user);
    }

    @Test
    public void ChangeUserPassword_changeUserPasswordTest(){
        UserService userService = new UserService(new FakeDataStore());
        userService.ChangeUserPassword("vionev","123456","yoyo");
        Assertions.assertEquals(userService.GetUserByUsername("vionev").GetPassword(), "yoyo");
    }

}
