package kr.megaptera.assignment.controllers;

import kr.megaptera.assignment.application.PostService;
import kr.megaptera.assignment.dtos.PostCreateRequestDto;
import kr.megaptera.assignment.dtos.PostResponseDto;
import kr.megaptera.assignment.dtos.PostUpdateRequestDto;
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

import java.util.List;

@RequestMapping("/posts")
@RestController
public class PostController {
  private final PostService postService;

  public PostController(PostService postService) {
    this.postService = postService;
  }

  @GetMapping()
  public List<PostResponseDto> getPosts() {
    return postService.getPosts();
  }

  @GetMapping("/{id}")
  public PostResponseDto getPostDatail(@PathVariable String id) {
    return postService.getPostDatail(id);
  }

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping()
  public PostResponseDto addPost(@RequestBody PostCreateRequestDto postCreateRequestDto) {
    return postService.addPost(postCreateRequestDto);
  }

  @PatchMapping("/{id}")
  public PostResponseDto editPost(@PathVariable String id,
                                  @RequestBody PostUpdateRequestDto postUpdateRequestDto) {
    return postService.editPost(id, postUpdateRequestDto);
  }

  @DeleteMapping("/{id}")
  public PostResponseDto deletePost(@PathVariable String id) {
    return postService.deletePost(id);
  }
}
