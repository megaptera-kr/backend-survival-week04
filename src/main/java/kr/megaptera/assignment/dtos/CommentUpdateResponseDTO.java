package kr.megaptera.assignment.dtos;

import lombok.Builder;

@Builder
public record CommentUpdateResponseDTO(String id,
                                       String author,
                                       String content) {

}
