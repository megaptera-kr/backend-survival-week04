package kr.megaptera.assignment.controllers;

import kr.megaptera.assignment.application.PostService;
import kr.megaptera.assignment.dtos.PostCreateDto;
import kr.megaptera.assignment.dtos.PostUpdateDto;
import kr.megaptera.assignment.exceptions.PostNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping
    public ResponseEntity findAll() {
        var posts = postService.findAll();
        return ResponseEntity.ok(posts);
    }

    @GetMapping("/{postId}")
    public ResponseEntity find(@PathVariable String postId) throws PostNotFoundException {
        var post = postService.find(postId);
        return ResponseEntity.ok(post);
    }

    @PostMapping
    private ResponseEntity add(@RequestBody PostCreateDto reqBody) {
        var post = postService.add(reqBody);
        return ResponseEntity.created(URI.create("/posts/" + post.getId())).body(post);
    }

    @PatchMapping("/{postId}")
    private ResponseEntity update(@PathVariable String postId, @RequestBody PostUpdateDto reqBody) throws PostNotFoundException {
        var post = postService.update(postId, reqBody);
        return ResponseEntity.ok(post);
    }

    @DeleteMapping("/{postId}")
    private ResponseEntity delete(@PathVariable String postId) throws PostNotFoundException {
        var post = postService.remove(postId);
        return ResponseEntity.ok(post);
    }

    @ExceptionHandler(PostNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void postNotFound() {
    }
}
