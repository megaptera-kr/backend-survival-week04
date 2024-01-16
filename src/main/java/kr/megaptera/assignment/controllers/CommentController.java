package kr.megaptera.assignment.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
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

import kr.megaptera.assignment.application.CommentService;
import kr.megaptera.assignment.dtos.CommentCreateDto;
import kr.megaptera.assignment.dtos.CommentDto;
import kr.megaptera.assignment.dtos.CommentUpdatedDto;
import kr.megaptera.assignment.exceptions.CommentNotFound;

@RestController
@RequestMapping("/comments")
@CrossOrigin
public class CommentController {
	private final CommentService commentService;

	public CommentController() {
		this.commentService = new CommentService();
	}

	@GetMapping
	public List<CommentDto> list(@RequestParam String postId) {
		List<CommentDto> commentDtos = commentService.getCommentDtos(postId);
		return commentDtos;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CommentDto create(@RequestParam String postId, @RequestBody CommentCreateDto commentCreateDto) {
		CommentDto created = commentService.createComment(postId, commentCreateDto);
		return created;
	}

	@PatchMapping("/{id}")
	public CommentDto update(@PathVariable String id, @RequestParam String postId,
		@RequestBody CommentUpdatedDto commentUpdatedDto) {
		CommentDto updated = commentService.updateComment(id, postId, commentUpdatedDto);
		return updated;
	}

	@DeleteMapping("/{id}")
	public CommentDto update(@PathVariable String id, @RequestParam String postId) {
		CommentDto deleted = commentService.deleteComment(id, postId);
		return deleted;
	}

	@ExceptionHandler(CommentNotFound.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String postNotFound() {
		return "댓글을 찾을 수 없습니다.";
	}
}
