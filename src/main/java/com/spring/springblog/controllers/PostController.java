package com.spring.springblog.controllers;

import com.spring.springblog.models.Ad;
import com.spring.springblog.models.Post;
import com.spring.springblog.repositories.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    private final PostRepository postDao;

    public PostController(PostRepository postDao){
        this.postDao = postDao;
    }

    @GetMapping("/posts")
    public String postsIndex(Model model){
        List<Post> posts = postDao.findAll();

        return "posts/index";
    }

//    @GetMapping("/posts")
//    //
//    public String postsIndex(Model model){
//        Post post1 = new Post("First Post", "here is my first post", 1);
//        Post post2 = new Post("Second Post", "here is my 2nd post", 2);
//        Post post3 = new Post("Third Post", "here is my 3rd post", 3);
//
//        List<Post> postList = new ArrayList<>();
//        postList.add(post1);
//        postList.add(post2);
//        postList.add(post3);
//
//        model.addAttribute("title", "All Posts");
//        model.addAttribute("posts", postList);
//
//        return "posts/index";
//    }

    @GetMapping("/posts/{id}")
    public String postView(Model model){
//        get single post by id later
        Post post = new Post("First Post", "here is my first post", 1);
        model.addAttribute("post", post);
        return "posts/show";
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String postForm(){
        return "Create a post here!";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String createPost(){
        return "Creating a new post...";
    }
}
