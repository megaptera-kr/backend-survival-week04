package kr.megaptera.assignment.controllers;


import kr.megaptera.assignment.application.PostService;
import kr.megaptera.assignment.dtos.PostCreateDto;
import kr.megaptera.assignment.dtos.PostDto;
import kr.megaptera.assignment.dtos.PostUpdateDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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
    @ResponseStatus(HttpStatus.CREATED)
    private PostDto createPost(@RequestBody PostCreateDto postCreateDto) {
        return postService.create(postCreateDto);
    }

    @PatchMapping("/{id}")
    private PostDto updatePost(@PathVariable("id") String postId, @RequestBody PostUpdateDto postUpdateDto) {
        return postService.update(postId, postUpdateDto);
    }

    @DeleteMapping("/{id}")
    private PostDto deletePost(@PathVariable("id") String postId) {
        return postService.delete(postId);
    }
}
