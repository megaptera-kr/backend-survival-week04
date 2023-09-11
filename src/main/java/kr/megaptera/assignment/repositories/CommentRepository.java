package kr.megaptera.assignment.repositories;

import kr.megaptera.assignment.models.Comment;
import kr.megaptera.assignment.models.CommentId;
import kr.megaptera.assignment.models.PostId;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommentRepository {
    private Map<CommentId, Comment> comments;

    public CommentRepository() {
        comments = new HashMap<CommentId, Comment>();
    }

    public List<Comment> findAll(PostId postId) {
        ArrayList<Comment> commentList = new ArrayList<>(comments.values());

        return commentList.stream()
                .filter(comment -> comment.postId().toString().equals(postId.toString()))
                .toList();
    }

    public void save(Comment comment) {
        comments.put(comment.id(), comment);
    }

    public Comment find(CommentId commentId) {
        return comments.get(commentId);
    }

    public void delete(CommentId commentId) {
        comments.remove(commentId);
    }
}
