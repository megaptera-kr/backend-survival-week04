package kr.megaptera.assignment.dtos;

import kr.megaptera.assignment.application.domain.Comment;
import lombok.Builder;

@Builder
public record CommentCreateResponseDTO(String id,
                                       String author,
                                       String content
) {
    public static CommentCreateResponseDTO from(Comment comment) {
        return CommentCreateResponseDTO.builder()
                .id(String.valueOf(comment.getId()))
                .author(comment.getAuthor())
                .content(comment.getContent())
                .build();
    }
}
