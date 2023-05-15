package kr.megaptera.assignment.models.dtos;

import kr.megaptera.assignment.models.Post;

public class PostDto {

    private String id;

    private String title;

    private String author;

    private String content;

    public PostDto() {
    }

    public PostDto(String id, String title, String author, String content) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.content = content;
    }

    public PostDto(Post post) {
        // DDD에서는 getter로 만들지 않기
        this.id = post.id().toString();
        this.title = post.title().toString();
        this.author = post.author().toString();
        this.content = post.content().toString();
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }
}
