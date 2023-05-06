package kr.megaptera.assignment.daos;

import kr.megaptera.assignment.dtos.CommentDto;
import kr.megaptera.assignment.dtos.request.RqCreateCommentDto;
import kr.megaptera.assignment.dtos.request.RqUpdateCommentDto;
import kr.megaptera.assignment.exceptions.NotFoundException;
import kr.megaptera.assignment.models.Author;
import kr.megaptera.assignment.models.Comment;
import kr.megaptera.assignment.models.CommentId;
import kr.megaptera.assignment.models.Content;
import kr.megaptera.assignment.models.PostId;
import kr.megaptera.assignment.repositories.CommentRepository;

import java.util.List;
import java.util.stream.Collectors;

public class CommentListDAO implements CommentDAO {

    private final CommentRepository commentRepository;

    public CommentListDAO() {
        this.commentRepository = new CommentRepository();
    }

    @Override
    public List<CommentDto> getCommentListByPostId(int postId) {
        List<Comment> commentList = commentRepository.findAllByPostId(PostId.of(postId));

        return commentList.stream().map(CommentDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public CommentDto createComment(RqCreateCommentDto dto, int postId) {
        Comment comment = new Comment(PostId.of(postId),
                Author.of(dto.getAuthor()),
                Content.of(dto.getContent()));

        Comment saveComment = commentRepository.saveComment(comment);
        return new CommentDto(saveComment);
    }

    @Override
    public CommentDto updateComment(RqUpdateCommentDto dto, int postId, int commentId) {
        Comment comment = commentRepository.findByCommentId(CommentId.of(commentId))
                .orElseThrow(NotFoundException::new);
        if (!comment.isEqualPostId(PostId.of(postId))) {
            throw new NotFoundException();
        }
        comment.update(Content.of(dto.getContent()));
        Comment updateComment = commentRepository.updateComment(comment);
        return new CommentDto(updateComment);
    }

    @Override
    public CommentDto deleteComment(int postId, int commentId) {
        Comment comment = commentRepository.findByCommentId(CommentId.of(commentId))
                .orElseThrow(NotFoundException::new);
        if (!comment.isEqualPostId(PostId.of(postId))) {
            throw new NotFoundException();
        }
        commentRepository.deleteComment(comment.Id());
        return new CommentDto(comment);
    }
}
