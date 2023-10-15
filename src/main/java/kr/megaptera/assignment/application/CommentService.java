package kr.megaptera.assignment.application;

import kr.megaptera.assignment.dtos.comments.CommentDto;
import kr.megaptera.assignment.exceptions.PostNotFound;
import kr.megaptera.assignment.models.comments.Comment;
import kr.megaptera.assignment.models.posts.PostId;
import kr.megaptera.assignment.repositories.CommentRepository;

import java.util.List;

public class CommentService {
    private final CommentRepository commentRepository;

    public CommentService() {
        this.commentRepository = new CommentRepository();
    }

    public CommentDto createComment(String postId, String author, String content) {
        Comment newComment = new Comment(PostId.of(postId), author, content);
        this.commentRepository.save(newComment);

        return CommentDto.of(newComment);
    }

    public List<CommentDto> getCommentDtos(String postId) {
        List<Comment> foundComments = this.commentRepository.findAll(postId);

        return foundComments.stream().map(CommentDto::of).toList();
    }

    public CommentDto updateComment(String commentId, String postId, String content) {
        Comment commentToBeUpdated = this.commentRepository.find(commentId, postId);

        if (commentToBeUpdated == null) {
            throw new PostNotFound();
        }

        commentToBeUpdated.update(content);

        return CommentDto.of(commentToBeUpdated);
    }

    public CommentDto removeComment(String commentId, String postId) {
        Comment commentToBeRemoved = this.commentRepository.find(commentId, postId);

        if (commentToBeRemoved == null) {
            throw new PostNotFound();
        }

        this.commentRepository.remove(commentId, postId);

        return CommentDto.of(commentToBeRemoved);
    }
}
