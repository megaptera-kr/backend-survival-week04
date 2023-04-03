package kr.megaptera.assignment.repositories;

import kr.megaptera.assignment.models.Comment;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class CommentRepository {
    private Map<String, Comment> comments;

    public CommentRepository() {
        comments = new HashMap<>();
    }

    public Comment[] findByPostId(String postId) {
        return comments.values()
                .stream()
                .filter(row -> row.getPostId().equals(postId))
                .toArray(Comment[]::new);
    }

    public Comment find(String commentId) {
        return comments.get(commentId);
    }

    public void add(Comment comment) {
        comments.put(comment.getId(), comment);
    }

    public void update(Comment comment) {
        comments.replace(comment.getId(), comment);
    }

    public void remove(Comment comment) {
        comments.remove(comment.getId());
    }
}
