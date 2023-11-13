package kr.megaptera.assignment.application;

import kr.megaptera.assignment.dtos.CommentDto;
import kr.megaptera.assignment.exceptions.PostNotFound;
import kr.megaptera.assignment.models.Comment;
import kr.megaptera.assignment.models.CommentAuthor;
import kr.megaptera.assignment.models.CommentId;
import kr.megaptera.assignment.models.MultilineText;
import kr.megaptera.assignment.models.PostId;
import kr.megaptera.assignment.repositories.CommentRepository;

import java.util.ArrayList;
import java.util.List;

public class CommentService {
    private final CommentRepository commentRepository;


    public CommentService() {
        this.commentRepository = new CommentRepository();
    }

    public List<CommentDto> getCommentDtos(String postId) {
        List<Comment> comments = commentRepository.findAll();
        List<CommentDto> commentDtos = new ArrayList<>();
        for (Comment comment : comments) {
            if (!comment.postId().toString().equals(postId)) {
                continue;
            }
            commentDtos.add(new CommentDto(comment));
        }
        return commentDtos;
    }

    public CommentDto createCommentDto(String postId, CommentDto commentDto) {
        Comment comment = new Comment(PostId.of(postId), CommentAuthor.of(commentDto.getAuthor()), MultilineText.of(commentDto.getContent()));
        commentRepository.save(comment);
        return new CommentDto(comment);
    }

    public CommentDto updateCommentDto(String commentId, CommentDto commentDto) {
        Comment comment = commentRepository.find(CommentId.of(commentId));
        if (comment == null) {
            throw new PostNotFound();
        }
        comment.update(MultilineText.of(commentDto.getContent()));
        return new CommentDto(comment);
    }

    public CommentDto delete(String commentId) {
        Comment comment = commentRepository.find(CommentId.of(commentId));
        if (comment == null) {
            throw new PostNotFound();
        }
        commentRepository.delete(comment.id());
        return new CommentDto(comment);
    }
}
