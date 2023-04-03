package kr.megaptera.assignment.services;

import kr.megaptera.assignment.dtos.PostReadDto;
import kr.megaptera.assignment.models.Post;
import org.springframework.stereotype.Component;

@Component
public class PostDtoFactory {

    public PostReadDto create(Post post){

        return new PostReadDto(
                post.getId(),
                post.getTitle(),
                post.getAuthor(),
                post.getContent());

    }
}
