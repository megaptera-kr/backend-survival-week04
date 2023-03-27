package kr.megaptera.assignment.controllers;

import kr.megaptera.assignment.application.PostService;
import kr.megaptera.assignment.dtos.PostDto;
import kr.megaptera.assignment.exceptions.PostNotPound;
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
        postService = new PostService();
    }

    @GetMapping
    public List<PostDto> list() {

        List<PostDto> postDtos = postService.getPosts();

        return postDtos;
    }


    @GetMapping("/{id}")
    public PostDto detail(@PathVariable String id) {

        PostDto postDto = postService.getPostDto(id);

        return postDto;

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PostDto create(@RequestBody PostDto reqPostDto) {

        PostDto created = postService.createPost(reqPostDto);

        return created;

    }

    @PatchMapping("/{id}")
    public PostDto update(@PathVariable("id") String id,
                          @RequestBody PostDto postDto) {

        PostDto updated = postService.updatePost(id, postDto);

        return updated;
    }


    @DeleteMapping("/{id}")
    public PostDto delete(@PathVariable("id") String id) {

        PostDto postDto = postService.deletePost(id);

        return postDto;
    }

    @ExceptionHandler(PostNotPound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String postNotFound() {
        return "게시물을 찾을 수 없습니다.\n";
    }

}
