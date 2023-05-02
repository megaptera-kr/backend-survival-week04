package kr.megaptera.assignment.models.dtos;

import kr.megaptera.assignment.models.Comment;

public class CommentDto {

    private String id;

    private String author;

    private String content;

    public CommentDto() {
    }

    public CommentDto(String id, String author, String content) {
        this.id = id;
        this.author = author;
        this.content = content;
    }

    public CommentDto(Comment comment) {
        this.id = comment.id().toString();
        this.author = comment.author().toString();
        this.content = comment.content().toString();
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
