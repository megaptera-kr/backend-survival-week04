package kr.megaptera.assignment.application;

import java.util.List;
import kr.megaptera.assignment.domains.Post;
import kr.megaptera.assignment.domains.PostId;
import kr.megaptera.assignment.dtos.PostCreateDto;
import kr.megaptera.assignment.dtos.PostDto;
import kr.megaptera.assignment.dtos.PostUpdateDto;
import kr.megaptera.assignment.repositories.PostRepository;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<PostDto> findAll() {
        List<Post> posts = postRepository.findAll();
        return posts.stream()
                .map(post -> new PostDto(post))
                .toList();
    }

    public PostDto findById(String id) {
        Post post = findPostById(id);
        return new PostDto(post);
    }

    public PostDto create(PostCreateDto postCreateDto) {
        Post newPost = new Post(postCreateDto);
        postRepository.save(newPost);
        return new PostDto(newPost);
    }

    public PostDto update(String id, PostUpdateDto ppostUpdateDto) {
        Post post = findPostById(id);
        post.update(ppostUpdateDto);
        return new PostDto(post);
    }

    public PostDto delete(String id) {
        Post post = findPostById(id);
        postRepository.delete(PostId.of(id));
        return new PostDto(post);
    }

    public Post findPostById(String id) {
        return postRepository.findById(PostId.of(id));
    }
}
