package kr.megaptera.assignment.dtos;

import kr.megaptera.assignment.application.domain.Post;
import lombok.Builder;

@Builder
public record PostGetResponseDTO(
        String id,
        String title,
        String author,
        String content
) {
    public static PostGetResponseDTO from(Post post) {
        return PostGetResponseDTO.builder()
                .id(String.valueOf(post.getId()))
                .title(post.getTitle())
                .content(post.getContent())
                .author(post.getAuthor())
                .build();
    }
}
