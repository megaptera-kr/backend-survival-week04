package kr.megaptera.assignment.repositories;

import kr.megaptera.assignment.domain.comment.Comment;
import kr.megaptera.assignment.domain.comment.CommentId;
import kr.megaptera.assignment.domain.post.PostId;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommentRepository {

    private Map<PostId, List<Comment>> comments;

    public CommentRepository() {
        this.comments = new HashMap<PostId, List<Comment>>();
    }

    public List<Comment> findAll(PostId postId) {
        return comments.getOrDefault(postId, new ArrayList<>());
    }

    public Comment find(CommentId commentId, PostId postId) {
        return comments.get(postId).stream()
                .filter(comment -> comment.id().equals(commentId))
                .findFirst()
                .get();
    }

    public void save(PostId postId, Comment comment) {
        if (comments.get(postId) == null) {
            comments.put(postId, new ArrayList<Comment>());
        }
        
        comments.get(postId).add(comment);
    }

    public void delete(PostId postId, Comment comment) {
        comments.get(postId).remove(comment);
    }
}
