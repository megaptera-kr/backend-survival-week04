package kr.megaptera.assignment.models;

import kr.megaptera.assignment.dtos.posts.PostCreateDTO;
import kr.megaptera.assignment.dtos.posts.PostDetailDTO;

public class Post {
    private final PostId id;
    private SingleLineText title;
    private SingleLineText author;
    private MultiLineText content;

    public Post(PostId id) {
        this.id = id;
    }

    public Post(PostId id, SingleLineText title, SingleLineText author, MultiLineText content) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.content = content;
    }

    // Getters
    public PostId id() {
        return id;
    }

    public SingleLineText title() {
        return title;
    }

    public SingleLineText author() {
        return author;
    }

    public MultiLineText content() {
        return content;
    }

    public void updateTitleAndContent(SingleLineText title, MultiLineText content) {
        this.title = title;
        this.content = content;
    }

    public PostDetailDTO toPostDetailDTO() {
        return new PostDetailDTO(id().toString(), title().toString(), author.toString(), content().toString());
    }

    public static Post create(PostCreateDTO dto) {
        return new Post(
                PostId.generate(),
                SingleLineText.of(dto.title()),
                SingleLineText.of(dto.author()),
                MultiLineText.of(dto.content())
        );
    }
}
