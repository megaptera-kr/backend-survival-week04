package kr.megaptera.assignment.controllers;

import kr.megaptera.assignment.application.PostService;
import kr.megaptera.assignment.dtos.PostDto;
import kr.megaptera.assignment.dtos.request.RqCreatePostDto;
import kr.megaptera.assignment.dtos.request.RqUpdatePostDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/posts")
@RestController
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping()
    public ResponseEntity<List<PostDto>> getPostList () {
        return postService.getPostList();
    }

    @GetMapping("/{postId}")
    public ResponseEntity<PostDto> getPostById (@PathVariable("postId") int postId) {
        return postService.getPostById(postId);
    }

    @PostMapping()
    public ResponseEntity<PostDto> createPost(@RequestBody RqCreatePostDto dto) {
        return postService.createPost(dto);
    }

    @PatchMapping("/{postId}")
    public ResponseEntity<PostDto> updatePost(@RequestBody RqUpdatePostDto dto,
                                              @PathVariable("postId") int postId) {
        return postService.updatePost(dto, postId);
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<PostDto> deletePost(@PathVariable("postId") int postId) {
        return postService.deletePost(postId);
    }
}
