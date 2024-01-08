package kr.megaptera.assignment.application;

import kr.megaptera.assignment.domain.Comment;
import kr.megaptera.assignment.dtos.CommentDto;
import kr.megaptera.assignment.exceptions.CommentNotFound;
import kr.megaptera.assignment.repositories.CommentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CommentService {
    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public List<CommentDto> getCommentList(String postId) {
        log.info("postId: {}", postId);
        List<Comment> comments = commentRepository.findAll();

        return comments.stream().map(comment -> new CommentDto(comment)).toList();
    }

    public CommentDto createComment(String postId, CommentDto commentDto) {
        Comment comment = Comment.builder()
                .postId(postId)
                .author(commentDto.getAuthor())
                .content(commentDto.getContent())
                .build();
        commentRepository.save(comment);

        return new CommentDto(comment);
    }

    public CommentDto updateComment(String id, String postId, CommentDto commentDto) throws CommentNotFound {
        Comment comment = commentRepository.find(id, postId);
        comment.update(commentDto.getContent());
        commentRepository.save(comment);

        return new CommentDto(comment);
    }

    public CommentDto deleteComment(String id, String postId) throws CommentNotFound {
        Comment comment = commentRepository.find(id, postId);
        commentRepository.delete(comment.getId());

        return new CommentDto(comment);
    }

}
