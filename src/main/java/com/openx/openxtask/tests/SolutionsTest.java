package com.openx.openxtask.tests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.openx.openxtask.models.Geo;
import com.openx.openxtask.models.Post;
import com.openx.openxtask.models.User;
import com.openx.openxtask.solutions.LogicUtils;
import com.openx.openxtask.solutions.Solutions;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;


@SpringBootTest
public class SolutionsTest {

    @Autowired
    Solutions solutions = new Solutions();

    @Autowired
    LogicUtils logicUtils = new LogicUtils();


    String postsJson =
            "[{\"userId\":1, \"id\":1, \"title\":\"title1\", \"body\":\"asdasdasd\"}, " +
                    "{\"userId\":1, \"id\":2, \"title\":\"title1\", \"body\":\"asdasdasd\"}," +
                    "{\"userId\":1, \"id\":3, \"title\":\"title1\", \"body\":\"asdasdasd\"}," +
                    "{\"userId\":1, \"id\":4, \"title\":\"title2\", \"body\":\"asdasdasd\"}," +
                    "{\"userId\":1, \"id\":5, \"title\":\"title2\", \"body\":\"asdasdasd\"}" +
                    "]";

    String usersJson =
            "[{\"id\":1, \"name\":\"name1\"}, " +
                    "{\"id\":2, \"name\":\"name2\"}," +
                    "{\"id\":3, \"name\":\"name3\"}," +
                    "{\"id\":4, \"name\":\"name4\"}," +
                    "{\"id\":5, \"name\":\"name5\"}" +
                    "]";



    @Test
    @JsonIgnoreProperties(ignoreUnknown = true)
    public void testCountUsrPosts() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        List<Post> listPostsTest = mapper.readValue(postsJson, mapper.getTypeFactory().constructCollectionType(List.class, Post.class));
        List<User> listUsersTest = mapper.readValue(usersJson, mapper.getTypeFactory().constructCollectionType(List.class, User.class));
        User user = new User();
        user.setId(1);
        User user2 = new User();
        user2.setId(2);
        listUsersTest.add(user);
        listUsersTest.add(user2);
        Map<Integer, Integer> expectedMap = new HashMap<>();
        expectedMap.put(1, 5);
        for (int i=2; i<listUsersTest.size()-1; i++){
            expectedMap.put(i, 0);
        }
        Map<Integer, Integer> actualMap = solutions.fillPostsMap(listUsersTest, listPostsTest);
        Assert.assertThat(actualMap, is(expectedMap));
    }

    @Test
    @JsonIgnoreProperties(ignoreUnknown = true)
    public void testFindNotUniqueTitles() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        List<Post> listPostsTest = mapper.readValue(postsJson, mapper.getTypeFactory().constructCollectionType(List.class, Post.class));
        List<String> testList = solutions.findNotUniqueTitles(listPostsTest);
        int count = testList.size();
        assertEquals(2, count);
    }

    @Test
    @JsonIgnoreProperties(ignoreUnknown = true)
    public void testFindClosestNeighbour(){
        Geo cracow = new Geo();
        cracow.setLat("50.0614300");
        cracow.setLng("19.9365800");
        Geo gdansk = new Geo();
        gdansk.setLng("18.6463700");
        gdansk.setLat("54.3520500");

        Double dist = logicUtils.getDistance(cracow, gdansk);
        assertEquals(485, Math.round(dist));
    }

}
