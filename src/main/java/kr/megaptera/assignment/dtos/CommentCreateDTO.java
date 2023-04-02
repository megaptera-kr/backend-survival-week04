package kr.megaptera.assignment.dtos;

public class CommentCreateDTO {
    private String author;

    private String content;

    public CommentCreateDTO() {
    }

    public CommentCreateDTO(String author, String content) {
        this.author = author;
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
