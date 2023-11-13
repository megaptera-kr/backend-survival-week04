package kr.megaptera.assignment.controllers;

import kr.megaptera.assignment.application.PostService;
import kr.megaptera.assignment.domain.Post;
import kr.megaptera.assignment.dtos.Post.PostCreateDto;
import kr.megaptera.assignment.dtos.Post.PostResponseDto;
import kr.megaptera.assignment.dtos.Post.PostUpdateDto;
import kr.megaptera.assignment.exceptions.PostNotFound;
import kr.megaptera.assignment.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<PostResponseDto> listPost() {
        return postService.list();
    }

    @GetMapping("/{id}")
    public PostResponseDto getPost(@PathVariable String id) {
        return postService.get(id);

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PostResponseDto createPost(@RequestBody PostCreateDto postCreateDto) {
        return postService.create(postCreateDto);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public PostResponseDto patchPosts(@PathVariable String id, @RequestBody PostUpdateDto postUpdateDto) {
       return postService.update(id,postUpdateDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public PostResponseDto deletePost(@PathVariable String id) {
        return postService.delete(id);
    }

    @ExceptionHandler(PostNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private String postNotFound() {
        return "게시물을 찾을 수 없습니다.";
    }
}