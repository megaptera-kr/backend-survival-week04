package kr.megaptera.assignment.dto;

import kr.megaptera.assignment.model.Comment;

public class CommentDto {
    private String id;
    private String author;
    private String content;

    public CommentDto(Comment comment) {
        this.id = comment.id().toString();
        this.author = comment.author().toString();
        this.content = comment.content().toString();
    }

    public CommentDto(String id, String author, String content) {
        this.id = id;
        this.author = author;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
