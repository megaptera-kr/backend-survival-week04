package kr.megaptera.assignment.dtos;

public class PostCreateDto {
    private String title;
    private String author;
    private String content;

    public PostCreateDto() {

    }

    public PostCreateDto(String title, String author, String content) {
        this.title = title;
        this.author = author;
        this.content = content;
    }


    public String getTitle() {
        return title;
    }

    public PostCreateDto setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public PostCreateDto setAuthor(String author) {
        this.author = author;
        return this;
    }

    public String getContent() {
        return content;
    }

    public PostCreateDto setContent(String content) {
        this.content = content;
        return this;
    }
}
