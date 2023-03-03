package kr.megaptera.assignment.model.comment;

import kr.megaptera.assignment.model.post.*;

public class Comment {
    private CommentId id;
    private String author;
    private String content;
    private PostId postId;

    public Comment(String author, String content, PostId postId) {
        this.id = CommentId.generate();
        this.author = author;
        this.content = content;
        this.postId = postId;
    }

    public Comment(CommentId id, String author, String content, PostId postId) {
        this.id = id;
        this.author = author;
        this.content = content;
        this.postId = postId;
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

    public PostId postId() {
        return postId;
    }

    public void update(String content) {
        this.content = content;
    }
}
