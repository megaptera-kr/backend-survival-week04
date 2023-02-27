package kr.megaptera.assignment.controllers;

import kr.megaptera.assignment.application.PostService;
import kr.megaptera.assignment.dtos.PostDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    @GetMapping
    public List<PostDto> getPostDtos() {
        List<PostDto> postDtos = postService.getPostDtos();
        return postDtos;
    }

    @GetMapping("/{id}")
    public PostDto getPostDto(@PathVariable String id) {
        PostDto postDto = postService.getPostDto(id);
        return postDto;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PostDto addPostDto(@RequestBody PostDto postDto) {
        PostDto createdPostDto = postService.addPostDto(postDto);
        return createdPostDto;
    }

    @PatchMapping("/{id}")
    public PostDto updatePostDto(@PathVariable String id, @RequestBody PostDto postDto) {
        PostDto updatedPostDto = postService.updatePostDto(id, postDto);
        return updatedPostDto;
    }

    @DeleteMapping("/{id}")
    public PostDto removePostDto(@PathVariable String id) {
        PostDto deletedPostDto = postService.removePostDto(id);
        return deletedPostDto;
    }

}
