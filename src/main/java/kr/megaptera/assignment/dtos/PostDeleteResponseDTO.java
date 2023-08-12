package kr.megaptera.assignment.dtos;

public record PostDeleteResponseDTO(
        String id,
        String title,
        String author,
        String content
) {
}
