package kr.megaptera.assignment.models;

public class Comment {
    private PostId postId;
    private CommentId id;
    private String author;
    private String content;

    public Comment(PostId postId, CommentId id, String author, String content) {
        this.postId = postId;
        this.id = id;
        this.author = author;
        this.content = content;
    }

    public void update(String content) {
        this.content = content;
    }

    public PostId postId() {
        return postId;
    }

    public CommentId id() {
        return id;
    }

    public String author() {
        return author;
    }

    public String content() {
        return content;
    }
}
