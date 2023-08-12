package kr.megaptera.assignment.dtos;

import lombok.Builder;

@Builder
public record PostUpdateRequestDTO(
        String title,
        String content
) {
}
