package kr.megaptera.assignment.dtos;

import lombok.Builder;

@Builder
public record PostUpdateResponseDTO(
        String id,
        String title,
        String author,
        String content
) {
}
