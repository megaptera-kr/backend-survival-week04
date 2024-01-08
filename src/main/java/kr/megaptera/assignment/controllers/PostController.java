package kr.megaptera.assignment.controllers;

import kr.megaptera.assignment.application.PostService;
import kr.megaptera.assignment.dtos.posts.PostCreateDTO;
import kr.megaptera.assignment.dtos.posts.PostDetailDTO;
import kr.megaptera.assignment.dtos.posts.PostUpdateDTO;
import kr.megaptera.assignment.exceptions.PostNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;

    public PostController() {
        this.postService = new PostService();
    }

    @GetMapping
    public List<PostDetailDTO> list() {
        return postService.getPostDTOs();
    }

    @GetMapping("/{id}")
    public PostDetailDTO detail(@PathVariable String id) {
        return postService.getPostDTO(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PostDetailDTO create(@RequestBody PostCreateDTO dto) {
        return postService.createPost(dto);
    }

    @PatchMapping("/{id}")
    public PostDetailDTO update(@PathVariable String id, @RequestBody PostUpdateDTO dto) {
        return postService.updatePost(id, dto);
    }

    @DeleteMapping("/{id}")
    public PostDetailDTO delete(@PathVariable String id) {
        return postService.deletePost(id);
    }

    @ExceptionHandler(PostNotFoundException.class)
    public void handlePostNotFoundException() {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
}
