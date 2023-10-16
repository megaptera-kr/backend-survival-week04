package kr.megaptera.assignment.controllers;

import kr.megaptera.assignment.application.CommentService;
import kr.megaptera.assignment.dtos.CommentDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
@CrossOrigin("http://localhost:8000/")
public class CommentController {

    CommentService commentService;

    public CommentController() {
        this.commentService = new CommentService();
    }

    @GetMapping
    public List<CommentDto> list(@RequestParam String postId){
        return commentService.findAll(postId);
    }
    @PostMapping
    public CommentDto detail(
        @RequestParam String postId,
        @RequestBody CommentDto reqBody
    ){
        return commentService.create(postId, reqBody);
    }
    @PatchMapping("/{id}")
    public CommentDto update(
        @PathVariable String id,
        @RequestParam String postId,
        @RequestBody CommentDto reqBody
    ){
        return commentService.update(id,postId,reqBody);
    }

    @DeleteMapping("/{id}")
    public CommentDto delete(
        @PathVariable String id,
        @RequestParam String postId
    ){
        return commentService.delete(id,postId);
    }


}
