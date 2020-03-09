package com.openx.openxtask.solutions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.openx.openxtask.models.Post;
import com.openx.openxtask.models.User;
import org.junit.Test;

import java.io.File;
import java.net.URL;
import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;


public class Solutions {
    LogicUtils utils = new LogicUtils();

    public Map<Integer, Integer> fillPostsMap(List<User> users, List<Post> posts){
        Map<Integer, Integer> map = new HashMap<>();
        for (User u : users){
            map.put(u.getId(), 0);
        }
        for (Post p : posts){
            int usrId = p.getUserId();
            int val = map.get(usrId);
            map.put(usrId, ++val);
        }
        return map;
    }

    public List<String> printUsersAndPosts(List<User> users, List<Post> posts){
        List<String> usrPosts = new ArrayList<>();
        Map<Integer, Integer> tmp = fillPostsMap(users, posts);
        //fillPostsMap(users, posts);
        for (User u : users){
            String usrname = u.getUsername();
            Integer count = tmp.get(u.getId());
            utils.fillUsersList(usrPosts, usrname, count);
        }
        return usrPosts;
    }

    public List<String> findNotUniqueTitles(List<Post> posts){
        Set<String> titlesSet = new HashSet<>();
        Set<String> tmp = new HashSet<>();
        for (Post p : posts){
            boolean val = tmp.add(p.getTitle());
            if (val == false){
                titlesSet.add(p.getTitle());
            }
        }
        List<String> titles = new ArrayList<>(titlesSet);
        return titles;
    }

    public Map<Integer, Integer> findClosestNeighbour(List<User> users){
        Map<Integer, Integer> neighbours = new HashMap<>();
        for (User start : users){
            List<Double> tmp = new ArrayList<>();
            for (User end : users){
                if(!start.equals(end)) {
                    Double d = utils.getDistance(start.getAddress().getGeo(), end.getAddress().getGeo());
                    System.out.println(d);
                    tmp.add(d);
                }
            }
            int idx = utils.findIndexOfMin(tmp);
            neighbours.put(start.getId(), idx);
        }

        return neighbours;
    }






}

