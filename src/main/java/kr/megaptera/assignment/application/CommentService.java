package kr.megaptera.assignment.application;

import kr.megaptera.assignment.dto.CommentDto;
import kr.megaptera.assignment.model.Comment;
import kr.megaptera.assignment.model.CommentId;
import kr.megaptera.assignment.model.MultiLineText;
import kr.megaptera.assignment.model.Post;
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

    public CommentDto createComment(CommentDto commentDto, String postId) {
        Comment comment = new Comment(new PostId(postId),
                SingleLineText.of(commentDto.getAuthor()),
                MultiLineText.of(commentDto.getContent()));
        commentRepository.save(comment);
        return new CommentDto(comment);
    }


    public CommentDto updateComment(CommentDto commentDto, String id) {
        Comment comment = commentRepository.find(CommentId.of(id));
        comment.update(
                SingleLineText.of(commentDto.getAuthor()),
                MultiLineText.of(commentDto.getContent())
        );

        return new CommentDto(comment);
    }

    public void deleteComment(String id) {
        commentRepository.remove(CommentId.of(id));
    }
}
