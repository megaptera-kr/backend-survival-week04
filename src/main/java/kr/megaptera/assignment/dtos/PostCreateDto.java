package kr.megaptera.assignment.dtos;

import lombok.Data;

@Data
public class PostCreateDto {
    String title;
    String author;
    String content;
}
