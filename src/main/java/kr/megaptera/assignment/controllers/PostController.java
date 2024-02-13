package kr.megaptera.assignment.controllers;

import kr.megaptera.assignment.application.PostService;
import kr.megaptera.assignment.dtos.PostCreateDto;
import kr.megaptera.assignment.dtos.PostDto;
import kr.megaptera.assignment.dtos.PostUpdateDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    public PostController(){ this.postService = new PostService();}

    @GetMapping
    public List<PostDto> list(){
        List<PostDto> postDtos = postService.getPostDtos();

        return postDtos;
    }

    @GetMapping("/{id}")
    public PostDto detail(@PathVariable String id){
        PostDto postDto = postService.getPostDto(id);

        return postDto;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)  //HttpStatus : 201
    public PostDto create(@RequestBody PostCreateDto postCreateDto){
        PostDto created = postService.createPost(postCreateDto);

        return created;
    }

    @PatchMapping("/{id}")
    public PostDto update(@PathVariable String id,
                          @RequestBody PostUpdateDto postUpdateDto){
        PostDto updated = postService.updatePost(id, postUpdateDto);

        return updated;
    }

    @DeleteMapping("/{id}")
    public PostDto delete(@PathVariable String id){
        PostDto deleted = postService.deletePost(id);

        return deleted;
    }
}
