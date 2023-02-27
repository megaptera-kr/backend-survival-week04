package kr.megaptera.assignment.controllers;

import java.util.List;
import kr.megaptera.assignment.application.PostService;
import kr.megaptera.assignment.dtos.CreatePostRequest;
import kr.megaptera.assignment.dtos.CreatePostResponse;
import kr.megaptera.assignment.dtos.DeletePostResponse;
import kr.megaptera.assignment.dtos.GetPostListResponse;
import kr.megaptera.assignment.dtos.GetPostResponse;
import kr.megaptera.assignment.dtos.UpdatePostRequest;
import kr.megaptera.assignment.dtos.UpdatePostResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("http://localhost:8000")
@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatePostResponse createPost(@RequestBody CreatePostRequest request) {
        return postService.createPost(request.toPost());
    }

    @GetMapping
    public List<GetPostListResponse> getPostList() {
        return postService.getPosts();
    }

    @GetMapping("/{id}")
    public GetPostResponse getPost(@PathVariable Long id) {
        return postService.getPost(id);
    }

    @PatchMapping("/{id}")
    public UpdatePostResponse updatePost(@PathVariable Long id,
            @RequestBody UpdatePostRequest request) {
        return postService.updatePost(id, request);
    }

    @DeleteMapping("/{id}")
    public DeletePostResponse deletePost(@PathVariable Long id) {
        return postService.deletePost(id);
    }
}
