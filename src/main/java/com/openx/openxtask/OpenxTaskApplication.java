package com.openx.openxtask;

import com.openx.openxtask.repositories.PostRepositoryImpl;
import com.openx.openxtask.repositories.UserRepositoryImpl;
import com.openx.openxtask.solutions.Solutions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.util.List;
import java.util.Map;


@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class OpenxTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(OpenxTaskApplication.class, args);
        Solutions s = new Solutions();
        PostRepositoryImpl postRepository = new PostRepositoryImpl();
        postRepository.getPosts();
        UserRepositoryImpl userRepository = new UserRepositoryImpl();
        userRepository.getUsers();

        System.out.println("Point 1");
        List<String> task1;
        task1 = s.printUsersAndPosts(userRepository.getUserList(), postRepository.getPostList());
        System.out.println(task1);

        System.out.println("Point 2");
        List<String> task2;
        task2 = s.findNotUniqueTitles(postRepository.getPostList());
        System.out.println(task2);

        System.out.println("Point 3");
        Map<Integer, Integer> task3;
        task3 = s.findClosestNeighbour(userRepository.getUserList());
        System.out.println(task3);

    }

}
