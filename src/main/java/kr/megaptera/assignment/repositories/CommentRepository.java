package kr.megaptera.assignment.repositories;

import kr.megaptera.assignment.models.Comment;
import kr.megaptera.assignment.models.PostId;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CommentRepository {
    private final List<Comment> comments;

    public CommentRepository() {
        this.comments = new ArrayList<Comment>();
    }

    public List<Comment> getComments(String postId) {
        return comments.stream()
                .filter(comment -> comment.postId().equals(PostId.of(postId)))
                .collect(Collectors.toList());
    }
}