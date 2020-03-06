package com.openx.openxtask.repositories;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.openx.openxtask.models.Post;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class PostRepositoryImpl implements PostRepository {
    List<Post> postList;

    public List<Post> getPostList() {
        return postList;
    }

    public void getPosts(){
        ObjectMapper mapper = new ObjectMapper();
        try {
            List<Post> posts = mapper.readValue(new URL("https://jsonplaceholder.typicode.com/posts"), mapper.getTypeFactory().constructCollectionType(List.class, Post.class));
            this.postList = posts;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
