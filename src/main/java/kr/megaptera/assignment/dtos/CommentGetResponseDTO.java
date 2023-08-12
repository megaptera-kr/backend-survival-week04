package kr.megaptera.assignment.dtos;

import lombok.Builder;

@Builder
public record CommentGetResponseDTO(
        String id,
        String author,
        String content
) {
}
