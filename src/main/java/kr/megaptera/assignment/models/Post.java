package kr.megaptera.assignment.models;

import lombok.Data;

@Data
public class Post {
    String id;
    String title;
    String author;
    String content;
}
