package kr.megaptera.assignment.dtos;

import lombok.Builder;

@Builder
public record CommentCreateResponseDTO(String id,
                                       String author,
                                       String content
) {
}
