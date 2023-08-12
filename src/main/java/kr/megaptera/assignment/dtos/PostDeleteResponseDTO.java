package kr.megaptera.assignment.dtos;

import lombok.Builder;

@Builder
public record PostDeleteResponseDTO(
        String id,
        String title,
        String author,
        String content
) {
}
