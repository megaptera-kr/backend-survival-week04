package kr.megaptera.assignment.controllers;

import kr.megaptera.assignment.application.PostService;
import kr.megaptera.assignment.exceptions.PostNotFound;
import kr.megaptera.assignment.models.dtos.PostCreateDto;
import kr.megaptera.assignment.models.dtos.PostDto;
import kr.megaptera.assignment.models.dtos.PostUpdateDto;
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

@RequestMapping("/posts")
@RestController
public class PostController {

    private final PostService postService;

    // 생성자
    public PostController(PostService postService) {
        this.postService = postService;
    }

    // 전체 게시물 리스트 가져오기
    @GetMapping
    public List<PostDto> list() {
        return postService.getPosts();
    }

    // 특정 게시물 가져오기
    @GetMapping("/{id}")
    public PostDto details(
            @PathVariable String id
    ) {
        return postService.getPost(id);
    }

    // 게시물 새로 작성하기
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PostDto create(
            @RequestBody PostCreateDto postCreateDto) {
        return postService.createPost(postCreateDto);
    }

    // 게시물 수정하기
    @PatchMapping("/{id}")
    public PostDto update(
            @PathVariable String id,
            @RequestBody PostUpdateDto postUpdateDto
    ) {
        return postService.updatePost(id, postUpdateDto);
    }

    // 게시물 삭제하기
    @DeleteMapping("/{id}")
    public PostDto delete(
            @PathVariable String id
    ) {
        return postService.deletePost(id);
    }

    // 원하는 글이 없는 경우 404 (빈 리스트 또는 404로 return 되도록)
    @ExceptionHandler(PostNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String postNotFound() {
        return "There's no post you want to see.\n";
    }

}
