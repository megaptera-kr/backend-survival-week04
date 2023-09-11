package kr.megaptera.assignment.application;

import kr.megaptera.assignment.model.Post;
import kr.megaptera.assignment.model.PostId;
import kr.megaptera.assignment.dto.PostDto;
import kr.megaptera.assignment.repositories.PostRepository;

import java.util.List;

public class PostService {

    private final PostRepository postRepository;

    public PostService() {
        this.postRepository = new PostRepository();
    }

    public List<PostDto> getPostDtos() {
        List<Post> posts = postRepository.findAll();

        return posts.stream().map(post -> new PostDto(post)).toList();
    }

    public PostDto getPostDto(String id) {
        Post post = postRepository.find(PostId.of(id));
        return new PostDto(post);
    }
}
