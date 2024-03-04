package kr.megaptera.assignment.controllers;

import kr.megaptera.assignment.application.PostService;
import kr.megaptera.assignment.dtos.PostCreateDto;
import kr.megaptera.assignment.dtos.PostDto;
import kr.megaptera.assignment.dtos.PostUpdateDto;
import kr.megaptera.assignment.exceptions.PostNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
@CrossOrigin
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
    public PostDto detail(@PathVariable String id) {
        return postService.getPostDto(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PostDto create(@RequestBody PostCreateDto postCreateDto) {
        return postService.createPost(postCreateDto);
    }

    @PatchMapping("/{id}")
    public PostDto update(@PathVariable String id,
                          @RequestBody PostUpdateDto postUpdateDto) {
        return postService.updatePost(id, postUpdateDto);
    }

    @DeleteMapping("/{id}")
    public PostDto delete(@PathVariable String id) {
        return postService.deletePost(id);
    }

    @ExceptionHandler(PostNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    protected String postNotFound() {
        return "Not found post.";
    }
}