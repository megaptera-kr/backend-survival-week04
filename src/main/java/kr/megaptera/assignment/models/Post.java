package kr.megaptera.assignment.models;

import kr.megaptera.assignment.models.dtos.PostCreateDto;
import kr.megaptera.assignment.models.dtos.PostUpdateDto;

public class Post {

    private PostId id;

    private PostTitle title;

    private PostAuthor author;

    private MultilineText content;

    public Post(PostId id, PostTitle title, PostAuthor author, MultilineText content) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.content = content;
    }

    public Post(PostTitle title, PostAuthor author, MultilineText content) {
        this.id = new PostId();
        this.title = title;
        this.author = author;
        this.content = content;
    }

    // Create Post
    public Post(PostCreateDto postDto) {
        this.id = new PostId();
        this.title = PostTitle.of(postDto.getTitle());
        this.author = PostAuthor.of(postDto.getAuthor());
        this.content = MultilineText.of(postDto.getContent());
    }

    // Update post
    public void updatePost(PostUpdateDto postUpdateDto) {
        this.title = PostTitle.of(postUpdateDto.getTitle());
        this.content = MultilineText.of(postUpdateDto.getContent());
    }

    public PostId id() {
        return id;
    }

    public PostTitle title() {
        return title;
    }

    public PostAuthor author() {
        return author;
    }

    public MultilineText content() {
        return content;
    }

}
