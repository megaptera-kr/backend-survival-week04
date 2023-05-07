package kr.megaptera.assignment.controllers;


import kr.megaptera.assignment.application.PostService;
import kr.megaptera.assignment.dtos.PostCreateDto;
import kr.megaptera.assignment.dtos.PostDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @GetMapping("/{id}")
    private PostDto getPost(@PathVariable("id") String postId) {
        return postService.find(postId);
    }

    @PostMapping
    private PostDto createPost(@RequestBody PostCreateDto postCreateDto) {
        return postService.create(postCreateDto);
    }
}
