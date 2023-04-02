package kr.megaptera.assignment.controllers;

import kr.megaptera.assignment.application.PostService;
import kr.megaptera.assignment.dtos.PostCreateDto;
import kr.megaptera.assignment.dtos.PostDTO;
import kr.megaptera.assignment.exceptions.PostNotFound;
import kr.megaptera.assignment.models.PostUpdateDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
@CrossOrigin
public class PostController {

    private final PostService postService;

    public PostController() {
        this.postService = new PostService();
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PostDTO> getPosts() {
        return postService.getPosts();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PostDTO getPost(@PathVariable String id) {
        return postService.getPost(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PostDTO create(@RequestBody PostCreateDto postCreateDto) {
        return postService.createPost(postCreateDto);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PostDTO update(@PathVariable String id,
                          @RequestBody PostUpdateDto postUpdateDto) {
        return postService.updatePost(id, postUpdateDto);
    }

    @DeleteMapping("/{id}")
    public PostDTO delete(@PathVariable String id) {
        return postService.deletePost(id);
    }

    @ExceptionHandler(PostNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String postNotFound() {
        return "게시물을 찾을 수 없습니다.";
    }
}
