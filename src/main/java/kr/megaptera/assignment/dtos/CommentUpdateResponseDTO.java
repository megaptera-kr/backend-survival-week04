package kr.megaptera.assignment.dtos;

import kr.megaptera.assignment.application.domain.Comment;
import lombok.Builder;

@Builder
public record CommentUpdateResponseDTO(String id,
                                       String author,
                                       String content) {

    public static CommentUpdateResponseDTO from(Comment comment) {
        return CommentUpdateResponseDTO.builder()
                .id(comment.getId().toString())
                .author(comment.getAuthor())
                .content(comment.getContent())
                .build();
    }
}
