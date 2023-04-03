package kr.megaptera.assignment.dtos;

public class CommentCreateDto {
    private String author;
    private String content;
    public CommentCreateDto() {

    }

    public CommentCreateDto(String author, String content) {
        this.author = author;
        this.content = content;
    }

    public CommentCreateDto setAuthor(String author) {
        this.author = author;
        return this;
    }

    public CommentCreateDto setContent(String content) {
        this.content = content;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }


}
