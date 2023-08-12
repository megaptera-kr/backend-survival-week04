package kr.megaptera.assignment.dtos;

public record PostCreateResponseDTO(
        String id,
        String title,
        String author,
        String content
) {
}
