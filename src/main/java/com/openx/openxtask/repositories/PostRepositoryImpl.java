package com.openx.openxtask.repositories;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.openx.openxtask.models.Post;

import java.io.IOException;
import java.net.URL;

public class PostRepositoryImpl implements PostRepository {
    public void getPosts(){
        ObjectMapper mapper = new ObjectMapper();
        try {
            Post usrPost = mapper.readValue(new URL("https://jsonplaceholder.typicode.com/posts/1"), Post.class);
            System.out.println(usrPost);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        PostRepositoryImpl p = new PostRepositoryImpl();
        p.getPosts();
    }
}
