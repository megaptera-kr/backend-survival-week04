package kr.megaptera.assignment.domains;

import kr.megaptera.assignment.dtos.PostCreateDto;
import kr.megaptera.assignment.dtos.PostUpdateDto;

public class Post {
    private PostId postId;
    private String title;
    private String author;
    private String content;

    public Post(PostId postId, String title, String author, String content) {
        this.postId = postId;
        this.title = title;
        this.author = author;
        this.content = content;
    }

    public Post(PostCreateDto postCreateDto) {
        this(PostId.generateId(), postCreateDto.getTitle(), postCreateDto.getAuthor(), postCreateDto.getContent());
    }

    public boolean isExists(PostId postId) {
        return this.postId.equals(postId);
    }

    public PostId id() {
        return postId;
    }

    public String title() {
        return title;
    }

    public String author() {
        return author;
    }

    public String content() {
        return content;
    }

    public void update(PostUpdateDto postUpdateDto) {
        this.title = postUpdateDto.getTitle();
        this.content = postUpdateDto.getContent();
    }
}
