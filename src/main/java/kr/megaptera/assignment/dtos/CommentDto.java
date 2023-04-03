package kr.megaptera.assignment.dtos;

import kr.megaptera.assignment.models.Comment;
import kr.megaptera.assignment.models.CommentId;

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
        this(comment.id().toString(), comment.author(), comment.content());
    }

    public String getId() {
        return id;
    }

    public CommentDto setId(String id) {
        this.id = id;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public CommentDto setAuthor(String author) {
        this.author = author;
        return this;
    }

    public String getContent() {
        return content;
    }

    public CommentDto setContent(String content) {
        this.content = content;
        return this;
    }
}
