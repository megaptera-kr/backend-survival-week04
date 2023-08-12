package kr.megaptera.assignment.dtos;

public record PostCreateRequestDTO(
        String title,
        String author,
        String content
) {
}
