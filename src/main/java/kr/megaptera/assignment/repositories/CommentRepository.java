package kr.megaptera.assignment.repositories;

import kr.megaptera.assignment.exceptions.PostNotFoundException;
import kr.megaptera.assignment.models.Comment;
import kr.megaptera.assignment.models.CommentId;
import kr.megaptera.assignment.models.PostId;

import java.util.*;
import java.util.stream.Collectors;

public class CommentRepository {
    private final Map<PostId, List<Comment>> comments;

    public CommentRepository() {
        this.comments = new HashMap<>();
    }

    public List<Comment> findAll(PostId postId) {
        if (comments.get(postId) == null) {
            return new ArrayList<>();
        }
        return new ArrayList<>(this.comments.get(postId));
    }

    public void save(PostId postId, Comment comment) {
        if (comments.get(postId) == null) {
            List<Comment> commentsOnPostId = new ArrayList<>();
            commentsOnPostId.add(comment);
            comments.put(postId, commentsOnPostId);
        } else {
            List<Comment> commentsOnPostId = comments.get(postId);
            commentsOnPostId.add(comment);
            comments.put(postId, commentsOnPostId);
        }
        Set<Map.Entry<PostId, List<Comment>>> entries = comments.entrySet();
        for(Map.Entry<PostId, List<Comment>> tempEntry: entries) {
            for (Comment comment1: tempEntry.getValue()) {
            }
        }
    }

    public void update(PostId postId, Comment comment) {
        if (comments.get(postId) == null) {
            throw new PostNotFoundException();
        }
        List<Comment> collect = comments.get(postId).stream()
                .map(i -> i.id().equals(comment.id())
                        ? comment
                        : i)
                .collect(Collectors.toList());
        comments.put(postId, collect);
    }

    public Comment delete(CommentId commentId, PostId postId) {
        if (comments.get(postId) == null) {
            throw new PostNotFoundException();
        }
        List<Comment> searchedComments = this.comments.get(postId);
        for(Comment comment: searchedComments) {
        }
        Comment comment = searchedComments.stream()
                .filter(i -> i.postId().equals(postId) && i.id().equals(commentId))
                .findFirst()
                .get();
        searchedComments.remove(comment);
        return comment;
    }
}
