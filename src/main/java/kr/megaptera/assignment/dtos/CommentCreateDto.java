package kr.megaptera.assignment.dtos;

import kr.megaptera.assignment.models.Comment;

public class CommentCreateDto {
    private String author;
    private String content;

    public Comment toCommentModel (CommentCreateDto commentCreateDto) {
        return new Comment(commentCreateDto.author, commentCreateDto.content);
    }
}
