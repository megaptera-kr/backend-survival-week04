package kr.megaptera.assignment.application;

import kr.megaptera.assignment.dtos.PostCreateDto;
import kr.megaptera.assignment.dtos.PostDto;
import kr.megaptera.assignment.dtos.PostUpdateDto;
import kr.megaptera.assignment.models.MultiLineText;
import kr.megaptera.assignment.models.Post;
import kr.megaptera.assignment.models.PostId;
import kr.megaptera.assignment.repositories.PostRepository;

import java.util.List;

public class PostService {
    private final PostRepository postRepository;

    public PostService() {
        postRepository = new PostRepository();
    }

    public List<PostDto> getPostDtos() {
        List<Post> posts = postRepository.findAll();

        List<PostDto> postDtos = posts.stream()
                .map(post -> new PostDto(post))
                .toList();

        return postDtos;
    }

    public PostDto getPostDto(String id) {

        Post post = postRepository.find(PostId.of(id));
        return new PostDto(post);
    }

    public PostDto createDto(PostCreateDto postCreateDto) {

        Post post = new Post(
                postCreateDto.getTitle(),
                postCreateDto.getAuthor(),
                MultiLineText.of(postCreateDto.getContent()));

        postRepository.save(post);

        return new PostDto(post);
    }

    public PostDto updateDto(String id, PostUpdateDto postUpdateDto) {

        Post post = postRepository.find(PostId.of(id));

        post.update(postUpdateDto.getTitle(),
                MultiLineText.of(postUpdateDto.getContent()));

        return new PostDto(post);
    }

    public PostDto deleteDto(String id) {

        Post post = postRepository.find(PostId.of(id));

        postRepository.delete(PostId.of(id));

        return new PostDto(post);
    }
}
