package kr.megaptera.assignment.application;

import kr.megaptera.assignment.dtos.PostCreateDto;
import kr.megaptera.assignment.dtos.PostDto;
import kr.megaptera.assignment.dtos.PostUpdateDto;
import kr.megaptera.assignment.models.MultiLineText;
import kr.megaptera.assignment.models.Post;
import kr.megaptera.assignment.models.PostTitle;
import kr.megaptera.assignment.repositories.PostRepository;

import java.util.List;

public class PostService {
    private final PostRepository postRepository;

    public PostService() {
        postRepository = new PostRepository();
    }

    public List<PostDto> findAll() {
        List<Post> posts = postRepository.findAll();
        return posts.stream().map(post -> new PostDto(post)).toList();
    }

    public PostDto find(String postId) {
        Post post = postRepository.find(postId);
        return new PostDto(post);
    }

    public PostDto create(PostCreateDto postCreateDto) {
        Post post = new Post(
                PostTitle.of(postCreateDto.getTitle()),
                postCreateDto.getAuthor(),
                MultiLineText.of(postCreateDto.getContent())
        );
        postRepository.create(post);
        return new PostDto(post);
    }

    public PostDto update(String postId, PostUpdateDto postUpdateDto) {
        Post post = postRepository.find(postId);
        post.update(
                PostTitle.of(postUpdateDto.getTitle()),
                MultiLineText.of(postUpdateDto.getContent())
        );
        return new PostDto(post);
    }
}
