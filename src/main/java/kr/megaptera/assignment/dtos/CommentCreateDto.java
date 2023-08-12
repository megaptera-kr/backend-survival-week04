package kr.megaptera.assignment.dtos;

import kr.megaptera.assignment.models.Comment;
import kr.megaptera.assignment.models.CommentId;
import kr.megaptera.assignment.models.Post;

public class CommentCreateDto {
    private String author;
    private String content;

    public CommentCreateDto(String author, String content) {
        this.author = author;
        this.content = content;
    }

    public CommentCreateDto(Comment comment) {

        this(comment.author(), comment.content().toString());
    }

    public String getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }
}
