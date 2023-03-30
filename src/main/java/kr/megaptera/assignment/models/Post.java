package kr.megaptera.assignment.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Post {
    private String id;
    private String title;
    private String author;
    private String content;

    public Post clone() {
        return new Post(id, title, author, content);
    }
}
