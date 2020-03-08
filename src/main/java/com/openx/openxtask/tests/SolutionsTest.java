package com.openx.openxtask.tests;


import com.openx.openxtask.solutions.Solutions;
import org.json.JSONException;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SolutionsTest {

    @Autowired
    Solutions solutions;

    String usersTestJson = "";

    @Test
    void testCountUsrPosts() throws JSONException {

    }

}
