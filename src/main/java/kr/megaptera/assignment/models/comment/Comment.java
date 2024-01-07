package kr.megaptera.assignment.models.comment;

public class Comment {

    private CommentId id;
    private CommentAuthor author;
    private CommentContent content;

    public Comment(CommentAuthor author, CommentContent content) {
        this.id = CommentId.generate();
        this.author = author;
        this.content = content;
    }

    public CommentId id() {
        return id;
    }

    public CommentAuthor author() {
        return author;
    }

    public CommentContent content() {
        return content;
    }

    public void update(CommentContent commentContent) {
        this.content = commentContent;
    }
}
