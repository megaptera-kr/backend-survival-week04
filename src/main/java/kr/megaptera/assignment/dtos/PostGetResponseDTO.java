package kr.megaptera.assignment.dtos;

import lombok.Builder;

@Builder
public record PostGetResponseDTO(
        String id,
        String title,
        String author,
        String content
) {
}
