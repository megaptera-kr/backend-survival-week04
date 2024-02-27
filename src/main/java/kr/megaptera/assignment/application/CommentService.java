package kr.megaptera.assignment.application;

import java.util.List;

import kr.megaptera.assignment.dtos.CommentCreateDto;
import kr.megaptera.assignment.dtos.CommentDto;
import kr.megaptera.assignment.dtos.CommentUpdatedDto;
import kr.megaptera.assignment.models.Comment;
import kr.megaptera.assignment.models.CommentId;
import kr.megaptera.assignment.models.PostId;
import kr.megaptera.assignment.repositories.CommentRepository;

public class CommentService {

	private final CommentRepository commentRepository;

	public CommentService() {
		this.commentRepository = new CommentRepository();
	}

	public List<CommentDto> getCommentDtos(String postId) {
		List<Comment> comments = commentRepository.findAll(PostId.of(postId));
		return comments.stream().map(CommentDto::new).toList();
	}
	
	public CommentDto createComment(String postId, CommentCreateDto commentCreateDto) {
		Comment comment = new Comment(PostId.of(postId), commentCreateDto.getAuthor(), commentCreateDto.getContent());
		commentRepository.save(comment);
		return new CommentDto(comment);
	}

	public CommentDto updateComment(String id, String postId, CommentUpdatedDto commentUpdatedDto) {
		Comment comment = commentRepository.find(CommentId.of(id), PostId.of(postId));
		comment.update(commentUpdatedDto.getContent());
		return new CommentDto(comment);
	}

	public CommentDto deleteComment(String id, String postId) {
		Comment comment = commentRepository.find(CommentId.of(id), PostId.of(postId));
		commentRepository.delete(comment.id());
		return new CommentDto(comment);
	}

}
