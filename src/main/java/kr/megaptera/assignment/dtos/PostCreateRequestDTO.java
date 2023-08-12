package kr.megaptera.assignment.dtos;

import lombok.Builder;

@Builder
public record PostCreateRequestDTO(
        String title,
        String author,
        String content
) {
}
