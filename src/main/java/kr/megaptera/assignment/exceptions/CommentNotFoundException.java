package kr.megaptera.assignment.exceptions;

import kr.megaptera.assignment.models.CommentId;
import kr.megaptera.assignment.models.PostId;

public class CommentNotFoundException extends RuntimeException {
    public CommentNotFoundException(PostId postId, CommentId commentId) {
        super(
                String.format("%s - %s", postId.toString(), commentId.toString())
        );
    }
}
