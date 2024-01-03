package kr.megaptera.assignment.repositories;

import kr.megaptera.assignment.models.Comment;
import kr.megaptera.assignment.models.CommentId;
import kr.megaptera.assignment.models.PostId;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommentRepository {
    private final Map<PostId, Map<CommentId, Comment>> postIdCommentsMap;

    public CommentRepository() {
        this.postIdCommentsMap = new HashMap<>();
    }

    public List<Comment> findAll(PostId postId) {
        Map<CommentId, Comment> commentMap = postIdCommentsMap.get(postId);
        if (commentMap != null) {
            return commentMap.values().stream().sorted((o1, o2) -> o1.commentId().compareTo(o2.commentId())).toList();
        }
        return Collections.emptyList();
    }

    public Comment find(PostId postId, CommentId commentId) {
        Map<CommentId, Comment> commentMap = postIdCommentsMap.get(postId);
        return commentMap.get(commentId);
    }

    public void save(Comment comment) {
        if (!postIdCommentsMap.containsKey(comment.postId())) {
            postIdCommentsMap.put(comment.postId(), new HashMap<>());
        }
        postIdCommentsMap.get(comment.postId()).put(comment.commentId(), comment);
    }

    public void delete(PostId postId, CommentId commentId) {
        Map<CommentId, Comment> commentMap = postIdCommentsMap.get(postId);
        if (commentMap != null) {
            commentMap.remove(commentId);
        }
    }
}
