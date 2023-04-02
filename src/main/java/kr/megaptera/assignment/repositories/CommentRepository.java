package kr.megaptera.assignment.repositories;

import kr.megaptera.assignment.exceptions.CommentNotFound;
import kr.megaptera.assignment.models.Comment;
import kr.megaptera.assignment.models.CommentId;
import kr.megaptera.assignment.models.Post;
import kr.megaptera.assignment.models.PostId;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommentRepository {

    Map<CommentId, Comment> comments;

    public CommentRepository() {
        this.comments = new HashMap<>();
    }

    public List<Comment> findAll(PostId postId) {

        return comments.values().stream()
                .filter(comment -> comment.postId().equals(postId))
                .toList();
    }

    public Comment find(CommentId id, PostId postId) {
        Comment comment = comments.get(id);

        if (comment == null || !comment.postId().equals(postId)) {
            throw new CommentNotFound();
        }

        return comment;
    }

    public void save(Comment comment) {
        comments.put(comment.id(), comment);
    }

    public void delete(CommentId commentId) {
        comments.remove(commentId);
    }
}
