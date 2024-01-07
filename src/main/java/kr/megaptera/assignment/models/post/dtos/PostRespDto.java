package kr.megaptera.assignment.models.post.dtos;

import kr.megaptera.assignment.models.post.Post;

public class PostGetRespDto {
    String id;
    String title;
    String author;
    String content;

    public PostGetRespDto(Post post) {
        this.id = post.id();
        this.title = post.title();
        this.author = post.author();
        this.content = post.content();
    }

    public PostGetRespDto(String id, String title, String author, String content) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
