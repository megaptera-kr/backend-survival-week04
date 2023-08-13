package kr.megaptera.assignment.dtos;

import kr.megaptera.assignment.application.domain.Comment;
import lombok.Builder;

@Builder
public record CommentDeleteResponseDTO(
        String id,
        String author,
        String content
) {
    public static CommentDeleteResponseDTO from(Comment deletedComment) {
        return CommentDeleteResponseDTO.builder()
                .id(deletedComment.getId().toString())
                .author(deletedComment.getAuthor())
                .content(deletedComment.getContent())
                .build();
    }
}
