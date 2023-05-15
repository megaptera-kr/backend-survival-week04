package kr.megaptera.assignment.application;

import kr.megaptera.assignment.dtos.PostCreateDto;
import kr.megaptera.assignment.dtos.PostDto;
import kr.megaptera.assignment.dtos.PostUpdateDto;
import kr.megaptera.assignment.models.Post;
import kr.megaptera.assignment.repositories.PostRepository;

import java.util.List;
import java.util.stream.Collectors;

public class PostService {

    private final PostRepository postRepository;
    public PostService() {postRepository = new PostRepository();}

    public List<PostDto> findPostList() {
        List<Post> posts = postRepository.findAll();

        return posts.stream().map(PostDto::new).collect(Collectors.toList());
    }

    public PostDto findPost(String id) {
        Post post = postRepository.find(id);
        return new PostDto(post);
    }

    public PostDto createPost(PostCreateDto postCreateDto) {
        Post post = postCreateDto.toPostModel(postCreateDto);
        postRepository.save(post);
        return new PostDto(post);
    }

    public void updatePost(String id, PostUpdateDto postUpdateDto) {
        Post post = postRepository.find(id);
        post.update(postUpdateDto.title(), postUpdateDto.content());
    }

    public void deletePost(String id) {
        postRepository.delete(id);
    }
}
