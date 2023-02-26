package kr.megaptera.assignment.application;

import kr.megaptera.assignment.dtos.PostDto;
import kr.megaptera.assignment.models.Post;
import kr.megaptera.assignment.models.PostId;
import kr.megaptera.assignment.repositories.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public List<PostDto> getPostDtos() {
        List<Post> posts = postRepository.findAll();
        return posts.stream().map(post -> new PostDto(post)).toList();
    }

    public PostDto getPostDto(String id) {
        Post post = postRepository.find(PostId.of(id));
        return new PostDto(post);
    }

    public PostDto addPostDto(PostDto postDto) {
        Post post = new Post(postDto.getTitle(), postDto.getAuthor(), postDto.getContent());
        postRepository.save(post);
        return new PostDto(post);
    }

    public PostDto updatePostDto(String id, PostDto postDto) {
        Post post = postRepository.find(PostId.of(id));
        post.update(postDto.getTitle(), postDto.getContent());
        return new PostDto(post);
    }

    public PostDto removePostDto(String id) {
        Post post = postRepository.find(PostId.of(id));
        postRepository.delete(PostId.of(id));
        return new PostDto(post);
    }

}
