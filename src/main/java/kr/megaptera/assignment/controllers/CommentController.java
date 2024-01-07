package kr.megaptera.assignment.controllers;

import kr.megaptera.assignment.application.CommentService;
import kr.megaptera.assignment.dtos.CommentDto;
import kr.megaptera.assignment.exceptions.CommentNotFoundException;
import kr.megaptera.assignment.exceptions.PostNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
public class CommentController {

    private final CommentService commentService;

    public CommentController() {
        this.commentService = new CommentService();
    }

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<CommentDto> list(@RequestParam(name = "postId") String postId) {
        // get all commentDtos from commentService
        return this.commentService.list(postId);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public CommentDto create(
            @RequestParam(name = "postId") String postId,
            @RequestBody CommentDto commentDto
    ) {
        // create commentDto from commentService
        return this.commentService.create(postId, commentDto);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CommentDto update(
            @PathVariable String id,
            @RequestParam(name = "postId") String postId,
            @RequestBody CommentDto commentDto
    ) {
        // update commentDto from commentService
        return this.commentService.update(postId, id, commentDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CommentDto delete(@PathVariable String id,
                             @RequestParam(name = "postId") String postId
    ) {
        // delete commentDto from commentService
        return this.commentService.delete(postId, id);
    }

    @ExceptionHandler(PostNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String postNotFound() {
        return "Post Not Found!";
    }

    @ExceptionHandler(CommentNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String commentNotFound() {
        return "Comment Not Found!";
    }

}
