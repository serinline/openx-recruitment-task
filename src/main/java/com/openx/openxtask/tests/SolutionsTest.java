package com.openx.openxtask.tests;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.openx.openxtask.models.Post;
import com.openx.openxtask.models.User;
import com.openx.openxtask.solutions.Solutions;
import net.minidev.json.JSONValue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.criteria.CriteriaBuilder;
import java.io.DataInput;
import java.io.File;
import java.net.URL;
import java.util.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;


@SpringBootTest
public class SolutionsTest {

    @Autowired
    Solutions solutions;

//    String usersTestJson =
//            "[\n" +
//            "{\"userId\: 1,\n" +
//            "id: 1,\n" +
//            "title: \"sunt aut facere repellat provident occaecati excepturi optio reprehenderit\",\n" +
//            "body: \"quia et suscipit suscipit recusandae consequuntur expedita et cum reprehenderit molestiae ut ut quas totam nostrum rerum est autem sunt rem eveniet architecto\"\n" +
//            "},\n" +
//            "{\n" +
//            "userId: 1,\n" +
//            "id: 2,\n" +
//            "title: \"qui est esse\",\n" +
//            "body: \"est rerum tempore vitae sequi sint nihil reprehenderit dolor beatae ea dolores neque fugiat blanditiis voluptate porro vel nihil molestiae ut reiciendis qui aperiam non debitis possimus qui neque nisi nulla\"\n" +
//            "},\n" +
//            "{\n" +
//            "userId: 1,\n" +
//            "id: 3,\n" +
//            "title: \"ea molestias quasi exercitationem repellat qui ipsa sit aut\",\n" +
//            "body: \"et iusto sed quo iure voluptatem occaecati omnis eligendi aut ad voluptatem doloribus vel accusantium quis pariatur molestiae porro eius odio et labore et velit aut\"\n" +
//            "}" +
//            "]";


    JSONArray fillJSONArray() throws JSONException {
        JSONArray arr = new JSONArray();
        JSONObject obj1 = new JSONObject();
        obj1.put("userId", 1);
        obj1.put("id", 1);
        obj1.put("title", "sunt aut facere repellat provident occaecati excepturi optio reprehenderit");
        obj1.put("body", "quia et suscipit suscipit recusandae consequuntur expedita et cum reprehenderit molestiae ut ut quas");
        JSONObject obj2 = new JSONObject();
        obj2.put("userId", 1);
        obj2.put("id", 2);
        obj2.put("title", "sunt aut facere repellat provident occaecati excepturi optio reprehenderit");
        obj2.put("body", "quia et suscipit suscipit recusandae consequuntur expedita et cum reprehenderit molestiae ut ut quas");
        JSONObject obj3 = new JSONObject();
        obj3.put("userId", 1);
        obj3.put("id", 3);
        obj3.put("title", "sunt aut facere repellat provident occaecati excepturi optio reprehenderit");
        obj3.put("body", "quia et suscipit suscipit recusandae consequuntur expedita et cum reprehenderit molestiae ut ut quas");

        arr.put(obj1);
        arr.put(obj2);
        arr.put(obj3);

        return arr;
    }


//    @Test
//    @JsonIgnoreProperties(ignoreUnknown = true)
//    public void testCountUsrPosts() throws Exception {
//        ObjectMapper mapper = new ObjectMapper();
//        JSONArray arr = fillJSONArray();
//        //List<Post> listPostsTest = Arrays.asList(mapper.readValue(String.valueOf(arr), Post[].class));
//        List<Post> listPostsTest = mapper.readValue(new File("D:\\openx-task\\src\\main\\java\\com\\openx\\openxtask\\tests\\postsTest.json"), mapper.getTypeFactory().constructCollectionType(List.class, Post.class));
//        //List<User> listUsersTest = new ArrayList<>(0);
//        List<User> listUsersTest = mapper.readValue(new URL("https://jsonplaceholder.typicode.com/users"), mapper.getTypeFactory().constructCollectionType(List.class, User.class));
//        User user = new User();
//        user.setId(1);
//        User user2 = new User();
//        user2.setId(2);
//        listUsersTest.add(user);
//        listUsersTest.add(user2);
//        Map<Integer, Integer> expectedMap = new HashMap<>();
//        expectedMap.put(1, 3);
//        expectedMap.put(2, 0);
//        Map<Integer, Integer> actualMap = solutions.fillPostsMap(listUsersTest, listPostsTest);
//        System.out.println(actualMap);
//        assertThat(actualMap, is(expectedMap));
//    }

    @Test
    @JsonIgnoreProperties(ignoreUnknown = true)
    public void testFindNotUniqueTitles() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        List<Post> listPostsTest = mapper.readValue(new File("D:\\openx-task\\src\\main\\java\\com\\openx\\openxtask\\tests\\postsTest.json"), mapper.getTypeFactory().constructCollectionType(List.class, Post.class));

        List<String> testList = solutions.findNotUniqueTitles(listPostsTest);
        int count = testList.size();
        assertEquals(3, count);
    }

}
