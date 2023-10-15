package kr.megaptera.assignment.application;

import kr.megaptera.assignment.domain.Post;
import kr.megaptera.assignment.dtos.Post.PostCreateDto;
import kr.megaptera.assignment.dtos.Post.PostResponseDto;
import kr.megaptera.assignment.dtos.Post.PostUpdateDto;
import kr.megaptera.assignment.repositories.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }
    
    public List<PostResponseDto> list() {
        List<Post> posts = postRepository.findAll();
        return posts.stream().map(post -> new PostResponseDto(post.getId(), post.getTitle(), post.getAuthor(), post.getContent()))
                .toList();
    }

    public PostResponseDto get(String id) {
        Post post = postRepository.findPost(id);
        return new PostResponseDto(post.getId(),post.getTitle(),post.getAuthor(),post.getTitle());
    }

    public PostResponseDto create(PostCreateDto postCreateDto) {
        Post post = new Post(postCreateDto.title(),postCreateDto.author(),postCreateDto.content());
        Post savedPost = postRepository.save(post);
        return new PostResponseDto(savedPost.getId(), savedPost.getTitle(), savedPost.getAuthor(),savedPost.getTitle());
    }

    public PostResponseDto update(String id, PostUpdateDto postUpdateDto) {
        Post post = postRepository.findPost(id);

        if (postUpdateDto.content() != null) {
            post.setContent(postUpdateDto.content());
        }

        if (postUpdateDto.title() != null) {
            post.setTitle(postUpdateDto.title());
        }

        Post UpdatedPost = postRepository.update(post);
        return new PostResponseDto(UpdatedPost.getId(), UpdatedPost.getTitle(), UpdatedPost.getAuthor(),UpdatedPost.getTitle());
    }

    public PostResponseDto delete(String id) {
        Post deletedPost = postRepository.delete(id);
        return new PostResponseDto(deletedPost.getId(), deletedPost.getTitle(), deletedPost.getAuthor(),deletedPost.getTitle());
    }
}
