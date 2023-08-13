package kr.megaptera.assignment.repositories;

import kr.megaptera.assignment.application.domain.Comment;
import kr.megaptera.assignment.application.domain.CommentId;
import kr.megaptera.assignment.exceptions.CommentNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class CommentRepository implements CRUDRepository<Comment, CommentId> {
    private final AtomicLong idFactory = new AtomicLong();
    private final ConcurrentHashMap<CommentId, Comment> map = new ConcurrentHashMap<>();

    @Override
    public Comment save(Comment comment) {
        CommentId commentId = new CommentId(idFactory.getAndIncrement());
        comment.setCommentId(commentId);
        map.put(commentId, comment);

        return comment;
    }

    @Override
    public Comment findById(CommentId commentId) {
        Comment comment = map.get(commentId);

        if (Objects.isNull(comment)) {
            throw new CommentNotFoundException();
        }
        return comment;
    }

    @Override
    public boolean exists(CommentId commentId) {
        Comment comment = map.get(commentId);

        if (Objects.isNull(comment)) {
            throw new CommentNotFoundException();
        }

        return true;
    }

    @Override
    public List<Comment> findAll() {
        return map.values().stream().toList();
    }

    @Override
    public Comment delete(CommentId commentId) {
        Comment comment = map.get(commentId);

        if (Objects.isNull(comment)) {
            throw new CommentNotFoundException();
        }

        map.remove(commentId);
        return comment;
    }

    @Override
    public void deleteAll() {
        map.clear();
    }
}
