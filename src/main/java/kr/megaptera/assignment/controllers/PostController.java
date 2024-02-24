package kr.megaptera.assignment.controllers;

import kr.megaptera.assignment.models.Post;
import kr.megaptera.assignment.repositories.PostRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/posts")
public class PostController {
    private final PostRepository postRepository;

    public PostController() {
        this.postRepository = new PostRepository();
    }

    @GetMapping
    public List<Post> getPosts(){
        postRepository.getPosts();
        return null;
    }
}
