package kr.megaptera.assignment.application;

import kr.megaptera.assignment.models.Comment;
import kr.megaptera.assignment.models.CommentContent;
import kr.megaptera.assignment.models.CommentId;
import kr.megaptera.assignment.models.PostId;
import kr.megaptera.assignment.repositories.CommentRepository;

import java.util.List;
import java.util.stream.Collectors;

public class CommentService {
    private final CommentRepository commentRepository;

    public CommentService() {
        this.commentRepository = new CommentRepository();
    }

    public List<Comment> getComments(String postId) {
        return commentRepository.getComments().stream()
                .filter(comment -> comment.postId().equals(postId))
                .collect(Collectors.toList());
    }

    public Comment postComment(String postId, String author, String content) {
        return commentRepository.postComment(postId, author, content);
    }

    public Comment patchComment(String id, String postId, String content) {
        Comment originComment = commentRepository.getComment(CommentId.of(id));
        Comment patchComment = new Comment(CommentId.of(id)
                                         , PostId.of(postId)
                                         , originComment.author()
                                         , CommentContent.of(content));
        commentRepository.patchComment(patchComment);
        return patchComment;
    }

    public Comment deleteComment(String id, String postId) {
        Comment originComment = commentRepository.getComment(CommentId.of(id));
        commentRepository.deleteComment(originComment);

        return originComment;
    }
}
