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
        comments = new HashMap<CommentId, Comment>();
    }

    public List<Comment> findAll(PostId postId) {
        List<Comment> commentList = comments.values().stream()
                .filter(comment -> comment.postId().equals(postId))
                .toList();
        return commentList;
    }

    public void save(Comment comment) {
        comments.put(comment.commentId(), comment);
    }

    public Comment find(PostId postId, CommentId commentId) {
        Comment comment = comments.get(commentId);

        if(comment == null || !comment.postId().equals(postId)){
            throw new CommentNotFound();
        }

        return comment;
    }

    public void delete(CommentId commentId) {
        comments.remove(commentId);
    }
}
