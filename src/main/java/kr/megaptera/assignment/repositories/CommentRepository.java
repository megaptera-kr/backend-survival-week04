package kr.megaptera.assignment.repositories;

import kr.megaptera.assignment.models.comments.Comment;
import kr.megaptera.assignment.models.comments.CommentId;
import kr.megaptera.assignment.models.posts.PostId;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommentRepository {
    Map<PostId, Map<CommentId, Comment>> commentsInPost = new HashMap<>();

    public List<Comment> findAll(String postId) {
        Map<CommentId, Comment> foundComments = this.commentsInPost
                .getOrDefault(PostId.of(postId), new HashMap<>());
        return new ArrayList<>(foundComments.values());
    }

    public Comment find(String commentId, String postId) {
        Map<CommentId, Comment> foundComments = this.commentsInPost
                .getOrDefault(PostId.of(postId), new HashMap<>());

        return foundComments.get(CommentId.of(commentId));
    }

    public void save(Comment comment) {
        Map<CommentId, Comment> foundComments = this.commentsInPost
                .get(comment.postId());

        if (foundComments == null) {
            this.commentsInPost.put(comment.postId(), new HashMap<>() {{
                put(comment.id(), comment);
            }});
        } else {
            foundComments.put(comment.id(), comment);
        }
    }

    public void remove(String commentId, String postId) {
        Map<CommentId, Comment> foundComments = this.commentsInPost
                .get(PostId.of(postId));

        if (foundComments != null) {
            foundComments.remove(CommentId.of(commentId));
        }
    }
}
