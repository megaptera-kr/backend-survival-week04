package kr.megaptera.assignment.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import kr.megaptera.assignment.models.post.Post;

public class PostDto {

    private final String id;
    private final String author;
    private String title;
    private String content;

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

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("author")
    public String getAuthor() {
        return author;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("content")
    public String getContent() {
        return content;
    }
}
