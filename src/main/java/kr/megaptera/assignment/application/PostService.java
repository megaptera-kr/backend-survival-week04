package kr.megaptera.assignment.application;

import kr.megaptera.assignment.dtos.PostCreateDto;
import kr.megaptera.assignment.dtos.PostDto;
import kr.megaptera.assignment.dtos.PostUpdateDto;
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

        return posts.stream().map(post -> new PostDto(post)).toList();
    }

    public PostDto getPostDto(String id) {
        Post post = postRepository.find(new PostId(id));

        return new PostDto(post);
    }

    public PostDto createPost(PostCreateDto postCreateDto) {
        Post post = new Post(postCreateDto.getTitle(), postCreateDto.getAuthor(), postCreateDto.getContent());

        postRepository.save(post);

        return new PostDto(post);
    }

    public PostDto updatePost(String id, PostUpdateDto postUpdateDto) {
        Post post = postRepository.find(new PostId(id));

        post.update(postUpdateDto.getTitle(), postUpdateDto.getContent());

        return new PostDto(post);
    }

    public PostDto deletePost(String id) {
        Post post = postRepository.find(new PostId(id));

        postRepository.delete(new PostId(id));

        return new PostDto(post);
    }
}
