package kr.megaptera.assignment.dtos;

import lombok.Data;

@Data
public class CommentCreateDto {
    private String author;
    private String content;
}
