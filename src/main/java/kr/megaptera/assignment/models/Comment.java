package kr.megaptera.assignment.models;

import com.github.f4b6a3.tsid.TsidCreator;
import kr.megaptera.assignment.dtos.CommentUpdateDto;

public class Comment {
    private String id;

    private String author;

    private String content;

    public String id() {
        return id;
    }

    public String author() {
        return author;
    }

    public String content() {
        return content;
    }


    public Comment(String author, String content) {
        this.id = TsidCreator.getTsid().toString();
        this.author = author;
        this.content = content;
    }

    public void update(CommentUpdateDto commentUpdateDto) {
        this.content = commentUpdateDto.content();
    }
}
