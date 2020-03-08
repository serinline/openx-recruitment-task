package com.openx.openxtask.tests;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.openx.openxtask.models.Post;
import com.openx.openxtask.models.User;
import com.openx.openxtask.solutions.Solutions;
import org.json.JSONException;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

@SpringBootTest
public class SolutionsTest {

    @Autowired
    Solutions solutions;

    String usersTestJson = "[\n" +
            "{\n" +
            "userId: 1,\n" +
            "id: 1,\n" +
            "title: \"sunt aut facere repellat provident occaecati excepturi optio reprehenderit\",\n" +
            "body: \"quia et suscipit suscipit recusandae consequuntur expedita et cum reprehenderit molestiae ut ut quas totam nostrum rerum est autem sunt rem eveniet architecto\"\n" +
            "},\n" +
            "{\n" +
            "userId: 1,\n" +
            "id: 2,\n" +
            "title: \"qui est esse\",\n" +
            "body: \"est rerum tempore vitae sequi sint nihil reprehenderit dolor beatae ea dolores neque fugiat blanditiis voluptate porro vel nihil molestiae ut reiciendis qui aperiam non debitis possimus qui neque nisi nulla\"\n" +
            "},\n" +
            "{\n" +
            "userId: 1,\n" +
            "id: 3,\n" +
            "title: \"ea molestias quasi exercitationem repellat qui ipsa sit aut\",\n" +
            "body: \"et iusto sed quo iure voluptatem occaecati omnis eligendi aut ad voluptatem doloribus vel accusantium quis pariatur molestiae porro eius odio et labore et velit aut\"\n" +
            "}" +
            "]";

    @Test
    public void testCountUsrPosts() throws JSONException {
        ObjectMapper mapper = new ObjectMapper();
        try {
            List<Post> listPostsTest = Arrays.asList(mapper.readValue(usersTestJson, Post[].class));
            List<User> listUsersTest = new ArrayList<>(0);
            User user = new User();
            user.setId(1);
            user.setUsername("User1");
            User user2 = new User();
            user2.setId(2);
            user2.setUsername("User2");
            listUsersTest.add(user);
            listUsersTest.add(user2);
            //assertEquals("", solutions.countUsrPosts(listUsersTest, listPostsTest));
            List<String> testList = solutions.countUsrPosts(listUsersTest, listPostsTest);
            List<String> expectedList = new ArrayList<>();
            expectedList.add("User1 napisał(a) 3 postów. \n");
            expectedList.add("User2 napisał(a) 0 postów. \n");
            assertArrayEquals(expectedList.toArray(), testList.toArray());
        } catch (Exception e){}
    }

}
