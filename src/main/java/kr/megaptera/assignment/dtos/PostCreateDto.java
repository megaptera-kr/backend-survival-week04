package kr.megaptera.assignment.dtos;

import lombok.Data;

@Data
public class PostCreateDto {
    private String title;
    private String author;
    private String content;
}
