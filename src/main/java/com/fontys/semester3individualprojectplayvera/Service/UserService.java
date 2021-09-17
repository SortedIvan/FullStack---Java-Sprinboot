package com.fontys.semester3individualprojectplayvera.Service;


import com.fontys.semester3individualprojectplayvera.interfaces.IFakeDataStore;
import com.fontys.semester3individualprojectplayvera.model.Game;
import com.fontys.semester3individualprojectplayvera.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService{

    IFakeDataStore iFakeDataStore;
    public UserService(IFakeDataStore iFakeDataStore){this.iFakeDataStore = iFakeDataStore;}

    @Override
    public List<User> GetAllUsers() {
        return iFakeDataStore.getAllUsers();
    }

    @Override
    public User GetUserByUsername(String username) {
        return  iFakeDataStore.GetUserByUsername(username);
    }

    @Override
    public void ChangeUserPassword(String username, String oldPassword, String newPassword) {
        iFakeDataStore.ChangeUserPassword(username,oldPassword,newPassword);
    }

}
