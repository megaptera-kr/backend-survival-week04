package kr.megaptera.assignment.repositories;

import kr.megaptera.assignment.exceptions.CommentNotFoundException;
import kr.megaptera.assignment.exceptions.PostNotFoundException;
import kr.megaptera.assignment.models.comment.Comment;
import kr.megaptera.assignment.models.comment.CommentContent;
import kr.megaptera.assignment.models.comment.CommentId;
import kr.megaptera.assignment.models.post.PostId;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommentRepository {

    private final Map<PostId, Map<CommentId, Comment>> repository;

    public CommentRepository() {
        this.repository = new HashMap<>();
    }

    public List<Comment> findAllByPostId(PostId postId) {
        if (!repository.containsKey(postId)) {
            throw new PostNotFoundException();
        }
        Map<CommentId, Comment> commentMap = repository.get(postId);
        return List.copyOf(
                commentMap.values()
                        .stream()
                        .toList()
        );
    }

    public void save(PostId postId, Comment comment) {
        Map<CommentId, Comment> commentMap = repository.get(postId);

        if (commentMap == null) {
            commentMap = new HashMap<>();
            repository.put(postId, commentMap);
        }
        
        commentMap.put(comment.id(), comment);
    }

    public Comment update(PostId postId, CommentId commentId, CommentContent commentContent) {
        if (!repository.containsKey(postId)) {
            throw new PostNotFoundException();
        }

        Map<CommentId, Comment> commentMap = repository.get(postId);

        Comment comment = getComment(commentMap, commentId);

        comment.update(commentContent);

        return comment;
    }

    public Comment delete(PostId postId, CommentId commentId) {
        if (!repository.containsKey(postId)) {
            throw new PostNotFoundException();
        }

        Map<CommentId, Comment> commentMap = repository.get(postId);

        Comment comment = getComment(commentMap, commentId);

        commentMap.remove(commentId);

        return comment;
    }

    private Comment getComment(Map<CommentId, Comment> commentMap, CommentId commentId) {
        Comment found = commentMap.get(commentId);
        if (found == null) {
            throw new CommentNotFoundException();
        }
        return found;
    }
}
