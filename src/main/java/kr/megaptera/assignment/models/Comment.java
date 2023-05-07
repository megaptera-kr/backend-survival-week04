package kr.megaptera.assignment.models;

public class Comment {
    private CommentId id;
    private PostId postId;
    private String author;
    private MultiLineText content;

    public Comment(CommentId id, PostId postId, String author, MultiLineText content) {
        this.id = id;
        this.postId = postId;
        this.author = author;
        this.content = content;
    }

    public CommentId id() {
        return id;
    }

    public PostId postId() {
        return postId;
    }

    public String author() {
        return author;
    }

    public MultiLineText content() {
        return content;
    }
}
