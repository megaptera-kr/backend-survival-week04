package kr.megaptera.assignment.dtos;

import kr.megaptera.assignment.models.Comment;

public class CommentDto {
    private String id;

    private String author;

    private String content;

    public String id() {
        return id;
    }

    public String author() {
        return author;
    }

    public String content() {
        return content;
    }

    public CommentDto(String id, String author, String content) {
        this.id = id;
        this.author = author;
        this.content = content;
    }

    public CommentDto(Comment comment) {
        this(comment.id(),comment.author(),comment.content());
    }
}
