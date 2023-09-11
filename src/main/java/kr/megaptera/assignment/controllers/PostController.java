package kr.megaptera.assignment.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import kr.megaptera.assignment.application.PostService;
import kr.megaptera.assignment.dto.PostDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/posts")
@RestController
public class PostController {
    private final PostService postService;

    public PostController() {
        this.postService = new PostService();
    }

    @GetMapping
    public List<PostDto> getList() {
        // application-layer 에 위임
        List<PostDto> postDtos = postService.getPostDtos();

        return postDtos;
    }

    @GetMapping("/{id}")
    public PostDto getDetail(@PathVariable String id) {
        PostDto postDto = postService.getPostDto(id);
        return postDto;
    }

    @PostMapping
    public PostDto create(@RequestBody PostDto postDto)  {
        PostDto created = postService.createPostDto(postDto);

        return created;
    }

    @PutMapping("/{id}")
    public PostDto update(@PathVariable String id,
                          @RequestBody PostDto postDto) {
        PostDto updated = postService.updatePostDto(id, postDto);

        return updated;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
    }
}
