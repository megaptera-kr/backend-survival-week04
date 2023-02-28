package kr.megaptera.assignment.repositories;

import java.util.ArrayList;
import java.util.List;
import kr.megaptera.assignment.domains.Comment;
import kr.megaptera.assignment.domains.CommentId;
import kr.megaptera.assignment.domains.PostId;
import org.springframework.stereotype.Repository;

@Repository
public class CommentRepository {

    private final List<Comment> comments = new ArrayList<>();

    public List<Comment> findAll(PostId postId) {
        return comments.stream()
                .filter(comment -> comment.isExists(postId))
                .toList();
    }

    public Comment findById(PostId postId, CommentId commentId) {
        return comments.stream()
                    .filter(comment -> comment.isExists(postId, commentId))
                    .findFirst()
                    .get();
    }

    public void save(Comment comment) {
        comments.add(comment);
    }

    public void delete(Comment comment) {
        comments.remove(comment);
    }
}
