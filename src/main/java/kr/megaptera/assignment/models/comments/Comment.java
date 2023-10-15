package kr.megaptera.assignment.models.comments;

import kr.megaptera.assignment.models.posts.PostId;

public class Comment {
    CommentId id;
    PostId postId;
    String author;
    String content;

    public Comment(CommentId id, PostId postId, String author, String content) {
        this.id = id;
        this.postId = postId;
        this.author = author;
        this.content = content;
    }

    public Comment(PostId postId, String author, String content) {
        this(CommentId.generate(), postId, author, content);
    }

    public CommentId id() {
        return this.id;
    }

    public PostId postId() {
        return this.postId;
    }

    public String author() {
        return this.author;
    }

    public String content() {
        return this.content;
    }

    public void update(String content) {
        this.content = content;
    }
}