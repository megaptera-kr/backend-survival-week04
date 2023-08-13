package kr.megaptera.assignment.dtos;

import kr.megaptera.assignment.application.domain.Comment;
import lombok.Builder;

@Builder
public record CommentCreateRequestDTO(String author,
                                      String content) {


    public Comment toEntity() {
        return Comment.builder()
                .author(this.author)
                .content(this.content)
                .build();
    }
}
