package kr.megaptera.assignment.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class Post {
    private String id;

    private String title;

    private String author;

    private String content;

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }

}
