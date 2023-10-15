package kr.megaptera.assignment.dtos.comments;

import kr.megaptera.assignment.models.comments.Comment;

public class CommentDto {
    String id;
    String postId;
    String author;
    String content;

    public CommentDto(String id, String postId, String author, String content) {
        this.id = id;
        this.postId = postId;
        this.author = author;
        this.content = content;
    }

    public CommentDto(Comment comment) {
        this(comment.id().toString(), comment.postId().toString(), comment.author(), comment.content());
    }

    public static CommentDto of(Comment comment) {
        return new CommentDto(comment.id().toString(), comment.postId().toString(), comment.author(), comment.content());
    }

    public String getId() {
        return id;
    }

    public String getPostId() {
        return postId;
    }

    public String getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }
}
