package kr.megaptera.assignment.repositories;

import kr.megaptera.assignment.models.Comment;
import kr.megaptera.assignment.models.CommentId;
import kr.megaptera.assignment.models.MultiLineText;
import kr.megaptera.assignment.models.PostId;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommentRepository {
    private final Map<CommentId, Comment> comments;

    public CommentRepository() {
        this.comments = new HashMap<CommentId, Comment>();
        this.comments.put(CommentId.of("1"),
                new Comment(CommentId.of("1"), PostId.of("1"), "pej", MultiLineText.of("EOT")));
        this.comments.put(CommentId.of("2"),
                new Comment(CommentId.of("2"), PostId.of("1"), "ppp", MultiLineText.of("RMF")));

    }
    public List<Comment> findAll(String postId) {
        List<Comment> comments = new ArrayList<>(this.comments.values());
        return comments.stream().filter(comment -> comment.postId().equals(PostId.of(postId))).toList();
    }
}
