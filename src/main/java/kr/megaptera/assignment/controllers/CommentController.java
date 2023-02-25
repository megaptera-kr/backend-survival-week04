package kr.megaptera.assignment.controllers;

import kr.megaptera.assignment.application.CommentService;
import kr.megaptera.assignment.dtos.CommentCreateRequestDto;
import kr.megaptera.assignment.dtos.CommentEditRequestDto;
import kr.megaptera.assignment.dtos.CommentResponseDto;
import org.springframework.http.HttpStatus;
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
public class CommentController {
  private final CommentService commentService;

  public CommentController(CommentService commentService) {
    this.commentService = commentService;
  }

  @GetMapping()
  List<CommentResponseDto> getComments(@RequestParam String postId) {
    return commentService.getComments(postId);
  }

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping()
  public CommentResponseDto addComment(@RequestParam String postId,
                                       @RequestBody
                                       CommentCreateRequestDto commentCreateRequestDto) {
    return commentService.addComment(postId, commentCreateRequestDto);
  }

  @PatchMapping("/{id}")
  public CommentResponseDto editComment(@PathVariable String id,
                                        @RequestParam String postId,
                                        @RequestBody CommentEditRequestDto commentEditRequestDto) {
    return commentService.editComment(id, postId, commentEditRequestDto);
  }

  @DeleteMapping("/{id}")
  public CommentResponseDto deleteComment(@PathVariable String id) {
    return commentService.deleteComment(id);
  }
}
