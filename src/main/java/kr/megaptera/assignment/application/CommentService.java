package kr.megaptera.assignment.application;

import kr.megaptera.assignment.dto.CommentDto;
import kr.megaptera.assignment.dto.PostDto;
import kr.megaptera.assignment.model.Comment;
import kr.megaptera.assignment.model.MultiLineText;
import kr.megaptera.assignment.model.PostId;
import kr.megaptera.assignment.model.SingleLineText;
import kr.megaptera.assignment.repositories.CommentRepository;

import java.util.List;

public class CommentService {
    private final CommentRepository commentRepository;

    public CommentService() {
        this.commentRepository = new CommentRepository();
    }

    public List<CommentDto> getCommentDto(String postId) {
        List<Comment> comments = commentRepository.findAll(postId);

        return comments.stream().map(comment -> new CommentDto(comment)).toList();
    }

    public CommentDto createComment(CommentDto commentDto, PostId postId) {
        Comment comment = new Comment(postId,
                SingleLineText.of(commentDto.getAuthor()),
                MultiLineText.of(commentDto.getContent()));
        commentRepository.save(comment);
        return new CommentDto(comment);
    }
}
