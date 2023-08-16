package kr.megaptera.assignment.repositories;

import kr.megaptera.assignment.dtos.CommentDto;
import kr.megaptera.assignment.exceptions.CommentNotFound;
import kr.megaptera.assignment.exceptions.PostNotFound;
import kr.megaptera.assignment.models.Comment;
import kr.megaptera.assignment.models.CommentId;
import kr.megaptera.assignment.models.MultilineText;
import kr.megaptera.assignment.models.Post;
import kr.megaptera.assignment.models.PostId;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommentRepository {
    private final HashMap<CommentId, Comment> comments;

    public CommentRepository(){
        this.comments = new HashMap<CommentId, Comment>();


    }

    public List<Comment> findALL(PostId postId) {

        List<Comment> list = new ArrayList<>(comments.values());

        return list.stream()
                .filter(comment -> comment.postId().equals(postId))
                .toList();

    }

    public void save(Comment comment) {
        comments.put(comment.id(), comment);
    }

    public Comment find(CommentId id, PostId postId) {

        Comment comment = comments.get(id);
        if (comment == null || !comment.postId().equals(postId)) {
            throw new CommentNotFound();
        }
        return comment;
    }

    public void delete(CommentId id) {
        comments.remove(id);
    }
}
