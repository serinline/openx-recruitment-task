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

    public Map<Integer, Integer> findClosestNeighbour(List<User> users){
        Map<Integer, Integer> neighbours = new HashMap<>();
        for (User start : users){
            List<Double> tmp = new ArrayList<>();
            for (User end : users){
                if(!start.equals(end)) {
                    Double d = utils.getDistance(start.getAddress().getGeo(), end.getAddress().getGeo());
                    tmp.add(d);
                }
            }
            //Collections.sort(tmp);
            int idx = utils.findIndexOfMin(tmp);
            neighbours.put(start.getId(), idx);
        }

        return neighbours;
    }

}

