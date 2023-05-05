package kr.megaptera.assignment.controllers;

import kr.megaptera.assignment.application.PostService;
import kr.megaptera.assignment.dtos.PostDto;
import kr.megaptera.assignment.exceptions.PostNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
        this.postService = new PostService();
    }

    @GetMapping
    private List<PostDto> list() {
        return postService.posts();
    }

    @GetMapping("/{id}")
    private PostDto detail(@PathVariable String id) {
        return postService.post(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private PostDto create(@RequestBody PostDto postDto) {
        return postService.create(postDto);
    }

    @PatchMapping("/{id}")
    private PostDto update(
        @PathVariable String id,
        @RequestBody PostDto postDto) {
        return postService.update(id, postDto);
    }

    @DeleteMapping("/{id}")
    private PostDto delete( @PathVariable String id) {
        return postService.delete(id);
    }

    @ExceptionHandler(PostNotFound.class)
    private String postNotFound() {
        return "게시물을 찾을 수 없습니다.";
    }
}
