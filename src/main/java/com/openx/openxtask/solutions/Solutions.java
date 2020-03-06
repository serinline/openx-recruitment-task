package com.openx.openxtask.solutions;

import com.openx.openxtask.models.Post;
import com.openx.openxtask.models.User;

import java.util.*;

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

    public List<String> findNotUniqueTitles(List<Post> posts){
        List<String> titles = new ArrayList<>();
        Set<String> tmp = new HashSet<>();
        for (Post p : posts){
            boolean val = tmp.add(p.getTitle());
            if (val == false){
                titles.add(p.getTitle());
            }
        }
        return titles;
    }

    List<User> findClosestNeighbour(){
        List<User> users = new ArrayList<>();

        return users;
    }

}

