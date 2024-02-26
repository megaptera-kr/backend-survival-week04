package kr.megaptera.assignment.models;

public class Comment {
    private CommentId id;

    private PostId postId;
    private String content;
    private String author;

    public Comment(CommentId id, PostId postId, String content, String author) {
        this.id = id;
        this.postId = postId;
        this.content = content;
        this.author = author;
    }

    public Comment(PostId postId, String content, String author) {
        this.id = CommentId.generate();
        this.postId = postId;
        this.content = content;
        this.author = author;
    }

    public void update(String content) {
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
    public String content() {
        return content;
    }
}
