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
            int idx = utils.findIndexOfMin(tmp);
            neighbours.put(start.getId(), idx);
        }

        return neighbours;
    }

    @Test
    @JsonIgnoreProperties(ignoreUnknown = true)
    public void testFindNotUniqueTitles() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        List<Post> listPostsTest = mapper.readValue(new File("D:\\openx-task\\src\\main\\java\\com\\openx\\openxtask\\tests\\postsTest.json"), mapper.getTypeFactory().constructCollectionType(List.class, Post.class));

        List<String> testList = findNotUniqueTitles(listPostsTest);
        int count = testList.size();
        assertEquals(3, count);
    }

    @Test
    @JsonIgnoreProperties(ignoreUnknown = true)
    public void testCountUsrPosts() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        //JSONArray arr = fillJSONArray();
        //List<Post> listPostsTest = Arrays.asList(mapper.readValue(String.valueOf(arr), Post[].class));
        List<Post> listPostsTest = mapper.readValue(new File("D:\\openx-task\\src\\main\\java\\com\\openx\\openxtask\\tests\\postsTest.json"), mapper.getTypeFactory().constructCollectionType(List.class, Post.class));
        //List<User> listUsersTest = new ArrayList<>(0);
        List<User> listUsersTest = mapper.readValue(new URL("https://jsonplaceholder.typicode.com/users"), mapper.getTypeFactory().constructCollectionType(List.class, User.class));
        User user = new User();
        user.setId(1);
        User user2 = new User();
        user2.setId(2);
        listUsersTest.add(user);
        listUsersTest.add(user2);
        Map<Integer, Integer> expectedMap = new HashMap<>();
        expectedMap.put(1, 3);
        for (int i=2; i<listUsersTest.size()-1; i++){
            expectedMap.put(i, 0);
        }
        Map<Integer, Integer> actualMap = fillPostsMap(listUsersTest, listPostsTest);
        System.out.println(actualMap);
        assertThat(actualMap, is(expectedMap));
    }



}

