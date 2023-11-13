package kr.megaptera.assignment.repositories;

import kr.megaptera.assignment.domain.Comment;
import kr.megaptera.assignment.domain.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CommentRepository {
    private Long newId = 0L;
    private static List<Comment> commentStore = new ArrayList<>();

    public List<Comment> findAll() {
        return commentStore.stream().toList();
    }

    public Comment findComment(String id) {
        return commentStore.stream().filter(item -> item.getId().equals(id)).findFirst().orElse(null);
    }

    public Comment save(Comment comment) {
        comment.setId(createId());
        commentStore.add(comment);
        return comment;
    }

    public Comment update(Comment comment) {
        commentStore = commentStore.stream().map(item -> item.getId().equals(comment.getId()) ? comment : item)
                .collect(Collectors.toList());
        return findComment(comment.getId());
    }

    private String createId() {
        newId++;
        return newId.toString();
    }

    public Comment delete(String id) {
        Comment comment = commentStore.stream().filter(item -> item.getId().equals(id)).findFirst().orElse(null);
        if (comment != null) {
            commentStore.remove(comment);
        }
        return comment;
    }
}
