package kr.megaptera.assignment.application;

import kr.megaptera.assignment.dtos.CommentDto;
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

    public List<CommentDto> getComments(String postId) {
        return commentRepository.getComments().stream()
                .filter(comment -> comment.postId().equals(postId))
                .map(CommentDto::new)
                .collect(Collectors.toList());
    }

    public CommentDto postComment(String postId, CommentDto content) {
        return new CommentDto(commentRepository.postComment(postId, content));
    }

    public CommentDto patchComment(String id, String postId, CommentDto content) {
        Comment originComment = commentRepository.getComment(CommentId.of(id));
        Comment patchComment = new Comment(CommentId.of(id)
                                         , PostId.of(postId)
                                         , originComment.author()
                                         , CommentContent.of(content.getContent()));
        commentRepository.patchComment(patchComment);
        return new CommentDto(patchComment);
    }

    public CommentDto deleteComment(String id, String postId) {
        Comment originComment = commentRepository.getComment(CommentId.of(id));
        commentRepository.deleteComment(originComment);

        return new CommentDto(originComment);
    }
}
