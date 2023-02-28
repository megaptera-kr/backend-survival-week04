package kr.megaptera.assignment.controllers;

import java.util.List;
import kr.megaptera.assignment.application.PostService;
import kr.megaptera.assignment.dtos.PostCreateDto;
import kr.megaptera.assignment.dtos.PostDto;
import kr.megaptera.assignment.dtos.PostUpdateDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    // 게시글 조회
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PostDto> list() {
        return postService.findAll();
    }

    // 게시글 상세 조회
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PostDto detail(@PathVariable String id) {
        return postService.findById(id);
    }

    // 게시글 작성
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PostDto create(@RequestBody PostCreateDto postCreateDto) {
        PostDto createdPost = postService.create(postCreateDto);
        return createdPost;
    }

    // 게시글 수정
    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PostDto update(@PathVariable String id,
                            @RequestBody PostUpdateDto postUpdateDto) {
        PostDto updatedPost = postService.update(id, postUpdateDto);
        return updatedPost;
    }

    // 게시글 삭제
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PostDto delete(@PathVariable String id) {
        PostDto deletedPost = postService.delete(id);
        return deletedPost;
    }
}
