package kr.megaptera.assignment.repositories;

import kr.megaptera.assignment.exceptions.CommentNotFound;
import kr.megaptera.assignment.models.Comment;
import kr.megaptera.assignment.models.CommentId;
import kr.megaptera.assignment.models.PostId;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommentRepository {
    private final Map<CommentId, Comment> comments;

    public CommentRepository() {
        this.comments = new HashMap<>();
    }

    public Comment findComment(String commentId) {
        Comment comment = comments.get(CommentId.of(commentId));
        if (comment == null) {
            throw new CommentNotFound();
        }
        return comment;
    }

    public List<Comment> findAll(String postId) {
        return comments.values().stream()
            .filter(comment -> comment.postId().equals(PostId.of(postId)))
            .toList();
    }

    public void save(Comment comment) {
        comments.put(comment.commentId(), comment);
    }

    public void update(Comment comment) {
        comments.replace(comment.commentId(), comment);
    }

    public void delete(Comment comment) {
        comments.remove(comment.commentId());
    }
}
