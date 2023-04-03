package kr.megaptera.assignment.dtos;

public class PostUpdateDto {
    private String title;
    private String content;
    public PostUpdateDto() {

    }

    public PostUpdateDto(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public PostUpdateDto setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getContent() {
        return content;
    }

    public PostUpdateDto setContent(String content) {
        this.content = content;
        return this;
    }
}
