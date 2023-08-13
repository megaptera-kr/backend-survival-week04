package kr.megaptera.assignment.dtos;

import kr.megaptera.assignment.application.domain.Post;
import lombok.Builder;

@Builder
public record PostDeleteResponseDTO(
        String id,
        String title,
        String author,
        String content
) {
    public static PostDeleteResponseDTO from(Post deletedPost) {
        return PostDeleteResponseDTO.builder()
                .id(String.valueOf(deletedPost.getId()))
                .title(deletedPost.getTitle())
                .author(deletedPost.getAuthor())
                .content(deletedPost.getContent())
                .build();
    }
}
