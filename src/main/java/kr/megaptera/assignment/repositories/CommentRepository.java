package kr.megaptera.assignment.repositories;

import kr.megaptera.assignment.exceptions.CommentNotFound;
import kr.megaptera.assignment.models.Comment;
import kr.megaptera.assignment.models.CommentId;
import kr.megaptera.assignment.models.PostId;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CommentRepository {

    private final Map<PostId, Map<CommentId, Comment>> comments;

    // 생성자 (이번 주차 과제에서는 외부 주입 없이 내부에서 생성하도록 함)
    public CommentRepository() {
        // PostId, CommentId class는 Hashable하므로 HashMap의 key object로 정의 가능
        this.comments = new HashMap<>();
    }

    // 댓글 찾기
    public Comment find(String id, String postId) {
        Map<CommentId, Comment> commentsOnPost = comments.get(PostId.of(postId));
        if (commentsOnPost == null)
            throw new CommentNotFound();

        return commentsOnPost.get(CommentId.of(id));
    }

    // 해당 게시물의 전체 댓글 리스트 찾기
    public List<Comment> findAllByPost(String postId) {
        Map<CommentId, Comment> commentsOnPost = comments.get(PostId.of(postId));
        if (commentsOnPost == null)
            commentsOnPost = new HashMap<>();
        return commentsOnPost.values().stream().toList();
    }

    // 댓글 저장하기
    public Comment save(String postId, Comment comment) {
        Map<CommentId, Comment> commentsOnPost = comments.get(PostId.of(postId));
        if (commentsOnPost == null)
            commentsOnPost = new HashMap<>();
        commentsOnPost.put(comment.id(), comment);
        comments.put(PostId.of(postId), commentsOnPost);
        return comment;
    }

    // 댓글 삭제하기
    public Comment delete(String id, String postId) {
        Comment comment = find(id, postId);
        comments.get(PostId.of(postId)).remove(CommentId.of(id));
        return comment;
    }
}
