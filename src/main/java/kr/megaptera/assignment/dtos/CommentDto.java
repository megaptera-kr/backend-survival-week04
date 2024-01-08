package kr.megaptera.assignment.dtos;

import kr.megaptera.assignment.models.comment.Comment;

public class CommentDto {

    private final String id;
    private final String author;
    private String content;

    public CommentDto(String id, String author, String content) {
        this.id = id;
        this.author = author;
        this.content = content;
    }

    public CommentDto(Comment comment) {
        this(comment.commentId().toString(), comment.commentAuthor().toString(), comment.commentContent().toString());
    }

    public String getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }
}
