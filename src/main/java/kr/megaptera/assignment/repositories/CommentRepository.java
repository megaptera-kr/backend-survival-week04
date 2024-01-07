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
        return commentMap.values()
                .stream()
                .toList();
    }

    public void save(PostId postId, Comment comment) {

        // PostID 유효성 검사? 실제로 PostRepository에서 PostId가 유효한지 검사하는 것이 맞는 것 같다.
        Map<CommentId, Comment> commentMap = repository.get(postId);
        // 처음 댓글을 달 때
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

        Comment target = getComment(commentMap, commentId);

        target.update(commentContent);

        return target;
    }

    public Comment delete(PostId postId, CommentId commentId) {
        if (!repository.containsKey(postId)) {
            throw new PostNotFoundException();
        }

        Map<CommentId, Comment> commentMap = repository.get(postId);

        Comment target = getComment(commentMap, commentId);

        commentMap.remove(commentId);

        return target;
    }

    private Comment getComment(Map<CommentId, Comment> commentMap, CommentId commentId) {
        Comment found = commentMap.get(commentId);
        if (found == null) {
            throw new CommentNotFoundException();
        }
        return found;
    }
}
