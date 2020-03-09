package com.openx.openxtask.solutions;

import com.openx.openxtask.models.Geo;

import java.util.List;

public class LogicUtils {

    public void fillUsersList(List<String> list, String username, Integer count){
        list.add(username + " napisał(a) " + count + " postów. \n");
    }

    public Double getDistance(Geo start, Geo end){
        Double lat1 = Double.parseDouble(start.getLat());
        Double lon1 = Double.parseDouble(start.getLng());
        Double lat2 = Double.parseDouble(end.getLat());
        Double lon2 = Double.parseDouble(end.getLng());
        final int R = 6371;

        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double tmp = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);

        double c = 2 * Math.atan2(Math.sqrt(tmp), Math.sqrt(1 - tmp));
        double distance = R * c ;
        double height = lat1 - lat2;
        distance = Math.pow(distance, 2) + Math.pow(height, 2);

        return Math.sqrt(distance);

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
