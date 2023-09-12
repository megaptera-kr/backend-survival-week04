package kr.megaptera.assignment.repositories;

import kr.megaptera.assignment.model.Comment;
import kr.megaptera.assignment.model.CommentId;
import kr.megaptera.assignment.model.MultiLineText;
import kr.megaptera.assignment.model.Post;
import kr.megaptera.assignment.model.PostId;
import kr.megaptera.assignment.model.SingleLineText;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommentRepository {
    private final Map<CommentId, Comment> comments;

    public CommentRepository() {
        this.comments = new HashMap<>();

        this.comments.put(CommentId.of("1"),
                new Comment(CommentId.of("1"), PostId.of("1"), SingleLineText.of("최소현"), MultiLineText.of("잘 보고갑니당\n")));
    }

    public List<Comment> findAll(String postId) {

        List<Comment> commentList = comments.values().stream()
                .filter(comment -> comment.postid().toString().equals(postId))
                .toList();

        return commentList;
    }

    public void save(Comment comment) {
        comments.put(comment.id(), comment);
    }
}
