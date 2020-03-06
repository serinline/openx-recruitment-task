package com.openx.openxtask.repositories;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.openx.openxtask.models.User;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    List<User> userList;

    public List<User> getUserList() {
        return userList;
    }

    public void getUsers(){
        ObjectMapper mapper = new ObjectMapper();
        try {
            List<User> users = mapper.readValue(new URL("https://jsonplaceholder.typicode.com/users"), mapper.getTypeFactory().constructCollectionType(List.class, User.class));
            this.userList = users;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
