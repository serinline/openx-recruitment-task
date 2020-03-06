package com.openx.openxtask.solutions;

import com.openx.openxtask.models.Post;
import com.openx.openxtask.models.User;

import java.util.List;
import java.util.Map;

public class LogicUtils {

    public void fillPostsMap(Map<Integer, Integer> map, List<User> users, List<Post> posts){
        for (User u : users){
            map.put(u.getId(), 0);
        }
        for (Post p : posts){
            int usrId = p.getUserId();
            int val = map.get(usrId);
            map.put(usrId, ++val);
        }
    }

    public void fillUsersList(List<String> list, String username, Integer count){
        list.add(username + " napisał(a) " + count + " postów. \n");
    }

}
