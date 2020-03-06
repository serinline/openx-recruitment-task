package com.openx.openxtask;

import com.openx.openxtask.repositories.PostRepositoryImpl;
import com.openx.openxtask.repositories.UserRepositoryImpl;
import com.openx.openxtask.solutions.Solutions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@SpringBootApplication
public class OpenxTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(OpenxTaskApplication.class, args);
        Solutions s = new Solutions();
        PostRepositoryImpl postRepository = new PostRepositoryImpl();
        postRepository.getPosts();
        UserRepositoryImpl userRepository = new UserRepositoryImpl();
        userRepository.getUsers();

        List<String> task1;
        task1 = s.countUsrPosts(userRepository.getUserList(), postRepository.getPostList());
        System.out.print(task1);

        List<String> task2;
        task2 = s.findNotUniqueTitles(postRepository.getPostList());
        System.out.print(task2);

        Map<Integer, Double> task3;
        task3 = s.findClosestNeighbour(userRepository.getUserList());
        System.out.print(task3);

    }

}
