package kr.megaptera.assignment.model;

import java.util.UUID;

public class Comment {
    private CommentId id;
    private PostId postId;
    private SingleLineText author;
    private MultiLineText content;

    public Comment(CommentId id, PostId postId, SingleLineText author, MultiLineText content) {
        this.id = id;
        this.postId = postId;
        this.author = author;
        this.content = content;
    }

    public Comment(PostId postId, SingleLineText author, MultiLineText content) {
        this.id = CommentId.of(UUID.randomUUID().toString().replace("-", ""));
        this.postId = postId;
        this.author = author;
        this.content = content;
    }

    public CommentId id(){
        return id;
    }

    public PostId postid(){
        return postId;
    }

    public SingleLineText author(){
        return author;
    }

    public MultiLineText content(){
        return content;
    }

    public void update(SingleLineText author, MultiLineText content) {
        this.author = author;
        this.content = content;
    }
}
