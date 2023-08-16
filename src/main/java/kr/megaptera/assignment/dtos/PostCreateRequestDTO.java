package kr.megaptera.assignment.dtos;

import kr.megaptera.assignment.application.domain.Post;
import lombok.Builder;

@Builder
public record PostCreateRequestDTO(
        String title,
        String author,
        String content
) {
    public Post toEntity() {
        return Post.builder()
                .title(this.title)
                .author(this.author)
                .content(this.content)
                .build();
    }
}
