package kr.megaptera.assignment.controllers;

import kr.megaptera.assignment.application.PostService;
import kr.megaptera.assignment.dtos.PostDto;
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

@RequestMapping("posts")
@RestController
public class PostController {
    private final PostService postService;

    public PostController() {
        postService = new PostService();
    }

    @GetMapping
    public List<PostDto> list() {
        return postService.getPostDtos();
    }

    @GetMapping("/{id}")
    public PostDto detail(@PathVariable("id") String id) {
        return postService.getPostDto(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PostDto create(@RequestBody PostDto postDto) {
        PostDto createdPost = postService.createPostDto(postDto);
        return createdPost;
    }

    @PatchMapping("/{id}")
    public PostDto update(@PathVariable("id") String id, @RequestBody PostDto postDto) {
        return postService.updatePostDto(id, postDto);
    }

    @DeleteMapping("/{id}")
    public PostDto delete(@PathVariable("id") String id) {
        return postService.deletePostDto(id);
    }

}
