package com.openx.openxtask.repositories;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.openx.openxtask.models.User;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    public void getUsers(){
        ObjectMapper mapper = new ObjectMapper();
        try {
            List<User> users = mapper.readValue(new URL("https://jsonplaceholder.typicode.com/users"), mapper.getTypeFactory().constructCollectionType(List.class, User.class));
            System.out.println(users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
