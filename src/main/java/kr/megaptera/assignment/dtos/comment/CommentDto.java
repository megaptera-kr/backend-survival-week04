package kr.megaptera.assignment.dtos.comment;

import kr.megaptera.assignment.domain.comment.Comment;

public class CommentDto {

    private String id;
    private String author;
    private String content;

    public CommentDto(String id, String author, String content) {
        this.id = id;
        this.author = author;
        this.content = content;
    }

    public CommentDto(Comment comment) {
        this(comment.id().toString(), comment.author(), comment.content().toString());
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
