package kr.megaptera.assignment.dtos;

import kr.megaptera.assignment.models.Post;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PostDto {
    private String id;
    private String title;
    private String author;
    private String content;

    public PostDto(Post post) {
        this(post.id().toString(), post.getTitle(),
                post.getAuthor(), post.getContent());
    }
}
