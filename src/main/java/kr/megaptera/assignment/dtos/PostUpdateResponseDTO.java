package kr.megaptera.assignment.dtos;

import kr.megaptera.assignment.application.domain.Post;
import lombok.Builder;

@Builder
public record PostUpdateResponseDTO(
        String id,
        String title,
        String author,
        String content
) {
    public static PostUpdateResponseDTO from(Post post) {
        return PostUpdateResponseDTO.builder()
                .id(String.valueOf(post.getId()))
                .title(post.getTitle())
                .author(post.getAuthor())
                .content(post.getContent())
                .build();
    }
}
