package kr.megaptera.assignment.application;

import kr.megaptera.assignment.dto.CommentDto;
import kr.megaptera.assignment.models.Comment;
import kr.megaptera.assignment.models.CommentId;
import kr.megaptera.assignment.models.CommentText;
import kr.megaptera.assignment.models.PostId;
import kr.megaptera.assignment.repositories.CommentRepository;

import java.util.List;

public class CommentService {

    private final CommentRepository commentRepository;

    public CommentService() {
        commentRepository = new CommentRepository();
    }

    public List<CommentDto> getAllList(String postId) {
        List<Comment> commentList = commentRepository.findAllComments(PostId.of(postId));
        return commentList.stream().map(comment -> new CommentDto(comment)).toList();
    }

    public CommentDto createComment(String postId, CommentDto commentDto) {
        Comment comment = new Comment(PostId.of(postId), commentDto.getAuthor(), CommentText.of(commentDto.getContent()));
        commentRepository.save(comment);
        return new CommentDto(comment);
    }

    public CommentDto updateComment(String commentId, CommentDto commentDto) {
        Comment comment = commentRepository.find(CommentId.of(commentId));
        comment.update(CommentText.of(commentDto.getContent()));
        System.out.println("Service updatecm :" + comment);
        return new CommentDto(comment);
    }

    public CommentDto removeComment(String commentId) {
        Comment comment = commentRepository.remove(CommentId.of(commentId));
        return new CommentDto(comment);
    }
}
