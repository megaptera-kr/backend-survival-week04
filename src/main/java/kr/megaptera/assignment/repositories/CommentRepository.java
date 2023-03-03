package kr.megaptera.assignment.repositories;

import kr.megaptera.assignment.exceptions.*;
import kr.megaptera.assignment.model.comment.*;
import kr.megaptera.assignment.model.post.*;

import java.util.*;

public class CommentRepository {

    Map<CommentId, Comment> comments;

    public CommentRepository() {
        this.comments = new HashMap<>();
    }

    public List<Comment> findAll(String postId) {
        List<Comment> list = comments.values().stream()
                .filter(t -> t.postId().equals(PostId.of(postId)))
                .toList();
        return list;
    }

    public void save(Comment comment) {
        comments.put(comment.id(), comment);
    }

    public Comment find(CommentId id, PostId postId) {
        Comment comment = comments.get(id);

        if (comment == null || !comment.postId().equals(postId)) {
            throw new CommentNotFound();
        }
        return comment;
    }

    public void delete(CommentId commentId) {
        comments.remove(commentId);
    }
}
