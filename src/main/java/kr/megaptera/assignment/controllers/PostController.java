package kr.megaptera.assignment.controllers;


import kr.megaptera.assignment.application.PostService;
import kr.megaptera.assignment.dtos.PostDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;

    public PostController() {
        postService = new PostService();
    }

    @GetMapping
    private List<PostDto> getPosts() {
        return postService.findAll();
    }
}
