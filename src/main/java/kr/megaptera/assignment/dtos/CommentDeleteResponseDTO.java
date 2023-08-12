package kr.megaptera.assignment.dtos;

import lombok.Builder;

@Builder
public record CommentDeleteResponseDTO(
        String id,
        String author,
        String content
) {
}
