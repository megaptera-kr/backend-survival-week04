package kr.megaptera.assignment.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import kr.megaptera.assignment.application.PostService;
import kr.megaptera.assignment.dtos.PostDto;
import kr.megaptera.assignment.models.Post;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController()
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;
    private final ObjectMapper objectMapper;

    public PostController(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
        this.postService = new PostService();
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PostDto> getPosts(){
        return postService.getPosts();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PostDto getPost(@PathVariable("id") String id){
        return postService.getPost(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PostDto postPost(@RequestBody PostDto post){
        return postService.postPost(post);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PostDto patchPost(@PathVariable("id") String id, @RequestBody PostDto post){
        return postService.patchPost(id, post);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PostDto deletePost(@PathVariable("id") String id){
        return postService.deletePost(id);
    }
}
