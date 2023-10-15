package kr.megaptera.assignment.dtos.Post;

public record PostCreateDto(
        String title,
        String author,
        String content
) {
}
