package kr.megaptera.assignment.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PostReadDto {
    private String id;
    private String title;
    private String author;
    private String content;
}
