package kr.megaptera.assignment.exceptions;

import kr.megaptera.assignment.models.PostId;

public class PostNotFoundException extends RuntimeException {
    private PostId postId;

    public PostNotFoundException(PostId postId) {
        this.postId = postId;
    }
}
