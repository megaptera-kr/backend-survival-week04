package kr.megaptera.assignment.dtos;

public record PostGetResponseDTO(
        String id,
        String title,
        String author,
        String content
) {
}
