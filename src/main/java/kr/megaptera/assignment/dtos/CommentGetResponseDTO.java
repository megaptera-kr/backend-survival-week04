package kr.megaptera.assignment.dtos;

import kr.megaptera.assignment.application.domain.Comment;
import lombok.Builder;

@Builder
public record CommentGetResponseDTO(
        String id,
        String author,
        String content
) {
    public static CommentGetResponseDTO from(Comment comment) {
        return CommentGetResponseDTO.builder()
                .id(String.valueOf(comment.getId()))
                .author(comment.getAuthor())
                .content(comment.getContent())
                .build();
    }
}
