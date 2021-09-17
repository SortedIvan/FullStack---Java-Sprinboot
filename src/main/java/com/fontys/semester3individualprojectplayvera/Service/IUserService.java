package com.fontys.semester3individualprojectplayvera.Service;

import com.fontys.semester3individualprojectplayvera.model.User;

import java.util.List;
public interface IUserService {
    List<User> GetAllUsers();
    User GetUserByUsername(String username);
    void ChangeUserPassword(String username, String oldPassword, String newPassword);

}
