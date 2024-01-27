package kr.megaptera.assignment.dtos;

import kr.megaptera.assignment.models.Comment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {
    private String id;
    private String author;
    private String content;

    public CommentDto(Comment comment){
        this(comment.id().toString(),
                comment.getAuthor(),
                comment.getContent());
    }
}

