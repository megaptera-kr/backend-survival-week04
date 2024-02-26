package kr.megaptera.assignment.controllers;

import kr.megaptera.assignment.application.PostService;
import kr.megaptera.assignment.models.Post;
import kr.megaptera.assignment.models.PostId;
import kr.megaptera.assignment.repositories.PostRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController()
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;
    public PostController() {
        this.postService = new PostService();
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Map<PostId, Post> getPosts(){
        return postService.getPosts();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Post getPost(@PathVariable("id") String id){
        return postService.getPost(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Post postPost(@RequestBody Post post){
        return postService.postPost(post);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Post patchPost(@PathVariable("id") String id, @RequestBody Post post){
        return postService.patchPost(id, post);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Post deletePost(@PathVariable("id") String id){
        return postService.deletePost(id);
    }
}
