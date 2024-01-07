package kr.megaptera.assignment.dtos;

import kr.megaptera.assignment.models.post.Post;

public class PostDto {

    private final String id;
    private final String author;
    private final String title;
    private final String content;

    public PostDto(String id, String author, String title, String content) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.content = content;
    }

    public PostDto(Post post) {
        this(post.id().toString(),
                post.author().toString(),
                post.title().toString(),
                post.content().toString()
        );
    }

    public String getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
