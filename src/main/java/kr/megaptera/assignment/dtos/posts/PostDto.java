package kr.megaptera.assignment.dtos.posts;

import kr.megaptera.assignment.models.posts.Post;

public class PostDto {
    String id;
    String title;
    String author;
    String content;

    public PostDto(String id, String title, String author, String content) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.content = content;
    }

    public PostDto(Post post) {
        this(post.id().toString(), post.title(), post.author(), post.content());
    }

    public static PostDto of(Post post) {
        return new PostDto(post.id().toString(), post.title(), post.author(), post.content());
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
