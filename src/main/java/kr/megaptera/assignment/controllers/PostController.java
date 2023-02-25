package kr.megaptera.assignment.controllers;

import kr.megaptera.assignment.application.PostService;
import kr.megaptera.assignment.dtos.post.PostCreateDto;
import kr.megaptera.assignment.dtos.post.PostDto;
import kr.megaptera.assignment.dtos.post.PostUpdateDto;
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

import java.util.List;

@RestController
@RequestMapping("/posts")
@CrossOrigin("*")
public class PostController {

    private final PostService postService;

    public PostController() {
        postService = new PostService();
    }

    // 게시글 조회 API
    @GetMapping()
    public List<PostDto> getPostList() {
        return postService.getPostList();
    }

    // 게시글 상세 조회 API
    @GetMapping("/{id}")
    public PostDto getPostDetail(@PathVariable String id) {
        return postService.getPostDetail(id);
    }

    // 게시글 작성 API
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public PostDto postNewPost(@RequestBody PostCreateDto postCreateDtoDto) {
        return postService.createPost(postCreateDtoDto);
    }

    // 게시글 수정 API
    @PatchMapping("/{id}")
    public PostDto updatePost(@PathVariable String id, @RequestBody PostUpdateDto postUpdateDto) {
        return postService.updatePost(id, postUpdateDto);
    }

    // 게시글 삭제 API
    @DeleteMapping("/{id}")
    public PostDto deletePost(@PathVariable String id) {
        return postService.deletePost(id);
    }
}
