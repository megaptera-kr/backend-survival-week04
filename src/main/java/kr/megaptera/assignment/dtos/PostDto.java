package kr.megaptera.assignment.dtos;

import lombok.Data;

@Data
public class PostDto {
    private String id;
    private String title;
    private String author;
    private String content;
}
