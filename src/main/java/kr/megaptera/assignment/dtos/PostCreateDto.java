package kr.megaptera.assignment.dtos;

import kr.megaptera.assignment.models.Post;

public class PostCreateDto {
    private String title;

    private String author;

    private String content;

    public Post toPostModel (PostCreateDto postCreateDto){
        return new Post(this.title,this.author,this.content);
    }
}
