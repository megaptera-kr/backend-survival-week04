package kr.megaptera.assignment.controllers;

import kr.megaptera.assignment.application.CommentService;
import kr.megaptera.assignment.dto.CommentDto;
import kr.megaptera.assignment.models.PostId;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/comments")
@CrossOrigin("*")
public class CommentController {

    private final CommentService commentService;

    public CommentController() {
        commentService = new CommentService();
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CommentDto> commentList(
            @RequestParam String postId
            ){
        return commentService.getAllList(postId);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CommentDto commentCreate(
            @RequestParam String postId
            ,@RequestBody CommentDto commentDto
    ){
        return commentService.createComment(postId, commentDto);
    }

    @PatchMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public CommentDto updateComment(
            @PathVariable String id
            ,@RequestParam String postId
            ,@RequestBody CommentDto commentDto
    ){
        //System.out.println("Contoller commentupdate : " + id +  "|" +  commentDto);
        return commentService.updateComment(id, commentDto);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public CommentDto removeComment(
            @PathVariable String id
            ,@RequestParam String postId
    ){
        return commentService.removeComment(id);
    }
}
