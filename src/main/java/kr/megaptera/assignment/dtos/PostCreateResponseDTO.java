package kr.megaptera.assignment.dtos;

import kr.megaptera.assignment.application.domain.Post;
import lombok.Builder;

@Builder
public record PostCreateResponseDTO(
        String id,
        String title,
        String author,
        String content
) {
    public static PostCreateResponseDTO from(Post post) {
        return PostCreateResponseDTO.builder()
                .id(String.valueOf(post.getId()))
                .title(post.getTitle())
                .author(post.getAuthor())
                .content(post.getContent())
                .build();
    }
}
