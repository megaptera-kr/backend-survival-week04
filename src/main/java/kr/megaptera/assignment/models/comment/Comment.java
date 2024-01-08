package kr.megaptera.assignment.models.comment;

public class Comment {

    private final CommentId commentId;
    private final CommentAuthor commentAuthor;
    private CommentContent commentContent;

    public Comment(CommentAuthor commentAuthor, CommentContent commentContent) {
        this.commentId = CommentId.generate();
        this.commentAuthor = commentAuthor;
        this.commentContent = commentContent;
    }

    public CommentId commentId() {
        return commentId;
    }

    public CommentAuthor commentAuthor() {
        return commentAuthor;
    }

    public CommentContent commentContent() {
        return commentContent;
    }

    public void update(CommentContent commentContent) {
        this.commentContent = commentContent;
    }
}
