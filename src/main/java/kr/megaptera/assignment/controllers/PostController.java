package kr.megaptera.assignment.controllers;

import kr.megaptera.assignment.application.PostService;
import kr.megaptera.assignment.dtos.posts.CreatePostDto;
import kr.megaptera.assignment.dtos.posts.PostDto;
import kr.megaptera.assignment.dtos.posts.UpdatePostDto;
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
        this.postService = new PostService();
    }

    // 게시글 조회
    @GetMapping("")
    List<PostDto> getPost() {
        return this.postService.getPostDtos();
    }

    // 게시글 상세 조회
    @GetMapping("/{id}")
    PostDto getPost(@PathVariable("id") String postId) {
        PostDto postDto = this.postService.getPostDto(postId);

        return postDto;
    }

    // 게시글 작성
    @PostMapping("")
    PostDto postPost(@RequestBody CreatePostDto createPostDto) {
        return this.postService.createPost(createPostDto);
    }

    // 게시글 수정
    @PatchMapping("/{id}")
    PostDto patchPost(@PathVariable("id") String postId, @RequestBody UpdatePostDto updatePostDto) {
        return this.postService.updatePost(postId, updatePostDto);
    }

    // 게시글 삭제
    @DeleteMapping("/{id}")
    PostDto deletePost(@PathVariable("id") String postId) {
        return this.postService.removePost(postId);
    }

    @ExceptionHandler(PostNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String postNotFound() {
        return "게시물을 찾을 수 없습니다";
    }

}
