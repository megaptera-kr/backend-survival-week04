package kr.megaptera.assignment.controllers;

import kr.megaptera.assignment.application.PostService;
import kr.megaptera.assignment.domains.post.Post;
import kr.megaptera.assignment.dtos.PostDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
@CrossOrigin("http://localhost:8000/")
public class PostController {

    PostService postService;
    public PostController() {
        this.postService = new PostService();
    }

    @GetMapping
    public List<PostDto> list(){return postService.getList();}
    @GetMapping("/{id}")
    public PostDto detail(@PathVariable String id){
        return postService.getDetail(id);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PostDto create(@RequestBody PostDto reqBody){
        PostDto createDto = postService.create(reqBody);
        return  createDto;
    }
    @PatchMapping("/{id}")
    public PostDto update(
        @PathVariable String id,
        @RequestBody PostDto reqBody){
        PostDto updateDto = postService.update(id,reqBody);
        return updateDto;
    }

    @DeleteMapping("/{id}")
    public PostDto delete(@PathVariable String id){
        PostDto deleteDto = postService.delete(id);
        return deleteDto;
    }

}
