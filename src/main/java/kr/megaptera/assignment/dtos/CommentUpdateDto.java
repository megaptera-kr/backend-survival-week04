package kr.megaptera.assignment.dtos;

import kr.megaptera.assignment.models.MultilineText;

public class CommentUpdateDto {
    private String content;

    public CommentUpdateDto(){

    }

    public CommentUpdateDto(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
