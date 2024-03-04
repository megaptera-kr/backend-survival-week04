package kr.megaptera.assignment.controllers;

import kr.megaptera.assignment.application.CommentService;
import kr.megaptera.assignment.application.PostService;
import kr.megaptera.assignment.dtos.PostCreateDto;
import kr.megaptera.assignment.dtos.PostDto;
import kr.megaptera.assignment.dtos.PostUpdateDto;
import kr.megaptera.assignment.exceptions.PostNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
@CrossOrigin
public class PostController {
    private final PostService postService;
    public PostController() {
        postService = new PostService();
    }
    @GetMapping
    public List<PostDto> list() {
        List<PostDto> postDtos = postService.getPostDtos();
        return postDtos;
    }

    @GetMapping("/{id}")
    public PostDto detail(@PathVariable String id) {
        PostDto postDto = postService.getPostDto(id);
        return postDto;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PostDto post(@RequestBody PostCreateDto postCreateDto) {
        PostDto created = postService.createPost(postCreateDto);
        return created;
    }

    @PatchMapping("/{id}")
    public PostDto update(@PathVariable String id, @RequestBody PostUpdateDto postUpdateDto) {
        PostDto updated = postService.updatePost(id, postUpdateDto);
        return updated;
    }

    @DeleteMapping("/{id}")
    public PostDto delete(@PathVariable String id) {
        PostDto deleted = postService.deletePost(id);
        return deleted;
    }

    @ExceptionHandler(PostNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String postNotFound() {
        return "게시물을 찾을 수 없습니다.";
    }
}
