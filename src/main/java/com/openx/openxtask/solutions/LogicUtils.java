package com.openx.openxtask.solutions;

import com.openx.openxtask.models.Geo;
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

    public Double getDistance(Geo start, Geo end){
        Double dist = 0.;
        Double earthRadius = 6371.;

        Double lat1 = Double.parseDouble(start.getLat());
        Double lon1 = Double.parseDouble(start.getLng());

        Double lat2 = Double.parseDouble(end.getLat());
        Double lon2 = Double.parseDouble(end.getLng());

        Double diffLat = Math.toRadians(lat2 - lat1);
        Double diffLon = Math.toRadians(lon2 - lon1);

        Double lat1Rad = Math.toRadians(lat1);
        Double lat2Rad = Math.toRadians(lat2);

        Double angle = Math.pow(Math.sin(diffLat / 2), 2) +
                        Math.pow(Math.sin(diffLon / 2), 2) *
                        Math.cos(lat1Rad) *
                        Math.cos(lat2Rad);
        dist = 2 * earthRadius * Math.asin(Math.sqrt(angle));

        return dist;
    }

    public int findIndexOfMin(List<Double> arr){
        int idx = 0;
        Double min  = arr.get(0);
        for (Double i : arr){
            if(min > i){
                min = i;
                idx = arr.indexOf(i);
            }
        }
        return idx;
    }

}
