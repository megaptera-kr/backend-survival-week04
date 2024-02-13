package kr.megaptera.assignment.repositories;

import kr.megaptera.assignment.models.Comment;
import kr.megaptera.assignment.models.CommentId;
import kr.megaptera.assignment.models.PostId;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommentRepository {

    Map<CommentId, Comment> comments;

    public CommentRepository(){this.comments = new HashMap<>();}

    public List<Comment> findAll(PostId postId) {
        List<Comment> commentList = comments.values().stream().
                filter(comment -> comment.getPostId().equals(postId))
                .toList();

        return commentList;
    }

    public Comment find(CommentId commentId, PostId postId) {
        Comment comment = comments.get(commentId);

        return comment;
    }

    public void save(Comment comment) {
        comments.put(comment.id(), comment);
    }

    public void delete(CommentId commentId) {
        comments.remove(commentId);
    }
}
