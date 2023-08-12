package kr.megaptera.assignment.dtos;

import lombok.Builder;

@Builder
public record CommentCreateRequestDTO(String author,
                                      String content) {


}
