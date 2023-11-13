package kr.megaptera.assignment.application;

import kr.megaptera.assignment.domain.Comment;
import kr.megaptera.assignment.dtos.comment.CommentCreateDto;
import kr.megaptera.assignment.dtos.comment.CommentResponseDto;
import kr.megaptera.assignment.dtos.comment.CommentUpdateDto;
import kr.megaptera.assignment.repositories.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public List<CommentResponseDto> list() {
        List<Comment> Comments = commentRepository.findAll();
        return Comments.stream().map(Comment -> new CommentResponseDto(Comment.getId(), Comment.getAuthor(), Comment.getContent()))
                .toList();
    }

    public CommentResponseDto get(String id) {
        Comment comment = commentRepository.findComment(id);
        return new CommentResponseDto(comment.getId(),comment.getAuthor(),comment.getContent());
    }

    public CommentResponseDto create(CommentCreateDto CommentCreateDto) {
        Comment comment = new Comment(CommentCreateDto.author(),CommentCreateDto.content());
        Comment savedComment = commentRepository.save(comment);
        return new CommentResponseDto(savedComment.getId(), savedComment.getContent(), savedComment.getAuthor());
    }

    public CommentResponseDto update(String id, CommentUpdateDto CommentUpdateDto) {
        Comment Comment = commentRepository.findComment(id);

        if (CommentUpdateDto.content() != null) {
            Comment.setContent(CommentUpdateDto.content());
        }

        Comment UpdatedComment = commentRepository.update(Comment);
        return new CommentResponseDto(UpdatedComment.getId(), UpdatedComment.getAuthor(), UpdatedComment.getContent());
    }

    public CommentResponseDto delete(String id) {
        Comment deletedComment = commentRepository.delete(id);
        return new CommentResponseDto(deletedComment.getId(), deletedComment.getAuthor(), deletedComment.getContent());
    }
}
