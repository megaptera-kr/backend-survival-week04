package kr.megaptera.assignment.controllers;

import kr.megaptera.assignment.application.*;
import kr.megaptera.assignment.dtos.post.*;
import kr.megaptera.assignment.exceptions.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/posts")
@CrossOrigin
public class PostController {

    private PostService postService;

    public PostController() {
        postService = new PostService();
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PostDto> getPostDtos() {
        List<PostDto> postDtos = postService.getPostDtos();
        return postDtos;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PostDto getPostDto(
            @PathVariable String id
    ) {
        return postService.getPostDto(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PostDto created(
            @RequestBody PostCreateDto postDto
    ) {
        PostDto created = postService.create(postDto);
        return created;
    }

    @PatchMapping("/{id}")
    public PostDto update(
            @PathVariable String id,
            @RequestBody PostUpdateDto postUpdateDto
    ) {
        PostDto update = postService.update(id, postUpdateDto);
        return update;
    }

    @DeleteMapping("/{id}")
    public PostDto delete(
            @PathVariable String id
    ) {
        PostDto delete = postService.delete(id);
        return delete;
    }

    @ExceptionHandler(PostNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String postNotFound() {
        return "Post Not Found...";
    }
}
