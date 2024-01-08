package kr.megaptera.assignment.application;

import kr.megaptera.assignment.domain.post.MultilineText;
import kr.megaptera.assignment.domain.post.Post;
import kr.megaptera.assignment.domain.post.PostId;
import kr.megaptera.assignment.dtos.post.PostCreateDto;
import kr.megaptera.assignment.dtos.post.PostDto;
import kr.megaptera.assignment.dtos.post.PostUpdateDto;
import kr.megaptera.assignment.repositories.PostRepository;

import java.util.List;

public class PostService {

    private final PostRepository postRepository;

    public PostService() {
        postRepository = new PostRepository();
    }

    public List<PostDto> getPostDtos() {
        List<Post> posts = postRepository.findAll();
        return posts.stream().map(post -> new PostDto(post)).toList();
    }

    public PostDto getPostDto(String id) {
        Post post = postRepository.find(PostId.of(id));

        return new PostDto(post);
    }

    public PostDto createPostDto(PostCreateDto postCreateDto) {
        Post post = new Post(
                postCreateDto.getTitle(),
                postCreateDto.getAuthor(),
                MultilineText.of(postCreateDto.getContent())
        );

        postRepository.save(post);

        return new PostDto(post);
    }

    public PostDto updatePostDto(String id, PostUpdateDto postUpdateDto) {
        Post post = postRepository.find(PostId.of(id));

        post.update(
                postUpdateDto.getTitle(),
                MultilineText.of(postUpdateDto.getContent())
        );

        return new PostDto(post);
    }

    public PostDto deletePostDto(String id) {
        Post post = postRepository.find(PostId.of(id));

        postRepository.delete(PostId.of(id));

        return new PostDto(post);
    }
}
