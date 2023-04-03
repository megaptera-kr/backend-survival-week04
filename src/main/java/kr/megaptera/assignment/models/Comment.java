package kr.megaptera.assignment.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Comment {
    private String id;
    private String postId;
    private String author;
    private String content;
}
