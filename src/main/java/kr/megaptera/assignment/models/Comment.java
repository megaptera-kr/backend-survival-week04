package kr.megaptera.assignment.models;

import kr.megaptera.assignment.dtos.comments.CommentCreateDTO;
import kr.megaptera.assignment.dtos.comments.CommentDetailDTO;

public class Comment {
    private CommentId commentId;
    private PostId postId;
    private SingleLineText author;
    private MultiLineText content;

    public Comment(
            CommentId commentId,
            PostId postId,
            SingleLineText author,
            MultiLineText content
    ) {
        this.commentId = commentId;
        this.postId = postId;
        this.author = author;
        this.content = content;
    }

    public static Comment create(PostId postId, CommentCreateDTO dto) {
        return new Comment(
                CommentId.generate(),
                postId,
                SingleLineText.of(dto.author()),
                MultiLineText.of(dto.content())
        );
    }

    public CommentId commentId() {
        return commentId;
    }

    public PostId postId() {
        return postId;
    }

    public SingleLineText author() {
        return author;
    }

    public MultiLineText content() {
        return content;
    }

    public void update(MultiLineText content) {
        this.content = content;
    }

    public CommentDetailDTO toCommentDetailDTO() {
        return new CommentDetailDTO(
                commentId().toString(),
                author().toString(),
                content().toString()
        );
    }
}
