package kr.megaptera.assignment.application.domain;

import kr.megaptera.assignment.dtos.CommentUpdateRequestDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Comment {
    private CommentId id;
    private String author;
    private String content;
    private PostId postId;

    @Builder
    private Comment(CommentId id, String author, String content, PostId postId) {
        this.id = id;
        this.author = author;
        this.content = content;
        this.postId = postId;
    }

    public void setCommentId(CommentId commentId) {
        this.id = commentId;
    }


    public void setPostId(PostId postId) {
        this.postId = postId;
    }

    public void update(CommentUpdateRequestDTO requestDTO) {
        if (requestDTO.content() != null) {
            this.content = requestDTO.content();
        }
    }
}
