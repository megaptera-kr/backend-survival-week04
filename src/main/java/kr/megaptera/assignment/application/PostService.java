package kr.megaptera.assignment.application;

import kr.megaptera.assignment.dtos.PostDto;
import kr.megaptera.assignment.exceptions.PostNotFound;
import kr.megaptera.assignment.models.MultilineText;
import kr.megaptera.assignment.models.Post;
import kr.megaptera.assignment.models.PostAuthor;
import kr.megaptera.assignment.models.PostId;
import kr.megaptera.assignment.models.PostTitle;
import kr.megaptera.assignment.repositories.PostRepository;

import java.util.List;

public class PostService {
    private final PostRepository postRepository;

    public PostService() {
        postRepository = new PostRepository();
    }

    public List<PostDto> getPostDtos() {
        List<Post> posts = this.postRepository.findAll();
        return posts.stream().map(post -> new PostDto(post)).toList();
    }

    public PostDto getPostDto(String id) {
        Post post = postRepository.find(PostId.of(id));
        if (post == null) {
            throw new PostNotFound();
        }
        return new PostDto(post);
    }

    public PostDto createPostDto(PostDto postDto) {
        Post post = new Post(PostTitle.of(postDto.getTitle()), PostAuthor.of(postDto.getAuthor()), MultilineText.of(postDto.getContent()));
        postRepository.save(post);
        return new PostDto(post);
    }

    public PostDto updatePostDto(String id, PostDto postDto) {
        Post post = postRepository.find(PostId.of(id));
        if (post == null) {
            throw new PostNotFound();
        }
        post.update(PostTitle.of(postDto.getTitle()), MultilineText.of(postDto.getContent()));
        return new PostDto(post);
    }

    public PostDto deletePostDto(String id) {
        Post post = postRepository.find(PostId.of(id));
        if (post == null) {
            throw new PostNotFound();
        }
        postRepository.delete(post.id());
        return new PostDto(post);
    }
}
