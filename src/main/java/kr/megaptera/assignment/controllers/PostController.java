package kr.megaptera.assignment.controllers;

import kr.megaptera.assignment.application.PostService;
import kr.megaptera.assignment.models.Post;
import kr.megaptera.assignment.repositories.PostRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;
    public PostController() {
        this.postService = new PostService();
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Post> getPosts(){
        return postService.getPosts();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Post getPost(@PathVariable("id") String id){
        return postService.getPost(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Post postPost(@RequestBody String title, String author, String content){
        return postService.postPost(title, author, content);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Post patchPost(@PathVariable("id") String id, @RequestBody String title, @RequestBody String content){
        return postService.patchPost(id, title, content);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Post deletePost(@PathVariable("id") String id){
        return postService.deletePost(id);
    }
}
