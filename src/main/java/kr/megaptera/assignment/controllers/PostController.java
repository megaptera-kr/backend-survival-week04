package kr.megaptera.assignment.controllers;

import kr.megaptera.assignment.application.PostService;
import kr.megaptera.assignment.dtos.PostCreateDto;
import kr.megaptera.assignment.dtos.PostDto;
import kr.megaptera.assignment.dtos.PostUpdateDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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

    /*
        게시글 조회
    */
    @GetMapping("")
    public List<PostDto> list() {
        List<PostDto> postDtos = postService.getPostDtos();
        return postDtos;
    }

    /*
        게시글 상세 조회
    */
    @GetMapping("/{id}")
    public PostDto detail(@PathVariable String id) {
        PostDto postDto = postService.getPostDto(id);
        return postDto;
    }

    /*
        게시글 작성
    */
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public PostDto create(@RequestBody PostCreateDto postCreateDto) {
        PostDto post = postService.createDto(postCreateDto);
        return post;
    }

    /*
        게시글 수정
    */
    @PatchMapping("/{id}")
    public PostDto update(
            @PathVariable String id,
            @RequestBody PostUpdateDto postUpdateDto) {
        PostDto post = postService.updateDto(id, postUpdateDto);
        return post;
    }

    /*
        게시글 삭제
    */
    @DeleteMapping("/{id}")
    public PostDto delete(@PathVariable String id) {
        PostDto postDto = postService.deleteDto(id);
        return postDto;
    }
}
