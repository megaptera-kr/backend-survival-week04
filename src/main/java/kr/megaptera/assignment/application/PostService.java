package kr.megaptera.assignment.application;

import kr.megaptera.assignment.dtos.post.*;
import kr.megaptera.assignment.model.post.*;
import kr.megaptera.assignment.repositories.*;

import java.util.*;

public class PostService {

    private PostRepository postRepository;

    public PostService() {
        postRepository = new PostRepository();
    }

    public List<PostDto> getPostDtos() {
        List<Post> posts = postRepository.findall();
        return posts.stream().map(PostDto::new).toList();
    }

    public PostDto getPostDto(String id) {
        Post post = postRepository.find(id);
        return new PostDto(post);
    }

    public PostDto create(PostCreateDto postDto) {
        Post post = new Post(
                postDto.getAuthor(),
                postDto.getTitle(),
                MultiLineText.of(postDto.getContent())
        );
        postRepository.save(post);

        return new PostDto(post);
    }

    public PostDto update(String id, PostUpdateDto postUpdateDto) {
        Post postUpdate = postRepository.find(id);

        postUpdate.update(
                postUpdateDto.getTitle(),
                MultiLineText.of(postUpdateDto.getContent())
        );
        return new PostDto(postUpdate);
    }


    public PostDto delete(String id) {
        Post post = postRepository.find(id);
        postRepository.delete(post);
        return new PostDto(post);
    }
}
