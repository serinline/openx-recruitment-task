package com.openx.openxtask.solutions;

import com.openx.openxtask.models.Post;
import com.openx.openxtask.models.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solutions {
    LogicUtils utils = new LogicUtils();

    public List<String> countUsrPosts(List<User> users, List<Post> posts){
        List<String> usrPosts = new ArrayList<>();
        Map<Integer, Integer> tmp = new HashMap<>();
        utils.fillPostsMap(tmp, users, posts);
        for (User u : users){
            String usrname = u.getUsername();
            Integer count = tmp.get(u.getId());
            utils.fillUsersList(usrPosts, usrname, count);
        }
        return usrPosts;
    }

    List<String> findNotUniqueTitles(){
        List<String> titles = new ArrayList<>();

        return titles;
    }

    List<User> findClosestNeighbour(){
        List<User> users = new ArrayList<>();

        return users;
    }

}

