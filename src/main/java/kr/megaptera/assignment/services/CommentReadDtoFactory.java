package kr.megaptera.assignment.services;

import kr.megaptera.assignment.dtos.CommentReadDto;
import kr.megaptera.assignment.models.Comment;
import org.springframework.stereotype.Component;

@Component
public class CommentReadDtoFactory {
    public CommentReadDto create(Comment comment){
        return new CommentReadDto(
                comment.getId(),
                comment.getAuthor(),
                comment.getContent());
    }
}
