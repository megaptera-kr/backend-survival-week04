package kr.megaptera.assignment.application;

import kr.megaptera.assignment.dtos.PostDto;
import kr.megaptera.assignment.models.Author;
import kr.megaptera.assignment.models.MultilineText;
import kr.megaptera.assignment.models.Post;
import kr.megaptera.assignment.models.Title;
import kr.megaptera.assignment.repositories.PostRepository;

import java.util.List;

public class PostService {
    private final PostRepository postRepository;

    public PostService() {
        this.postRepository = new PostRepository();
    }

    public List<PostDto> posts() {
        List<Post> posts = postRepository.findAll();
        return posts.stream().map(PostDto::new).toList();
    }

    public PostDto post(String id) {
        Post post = postRepository.findPost(id);
        return new PostDto(post);
    }

    public PostDto create(PostDto postDto) {
        Post post = new Post(
            Title.of(postDto.getTitle()),
            Author.of(postDto.getAuthor()),
            MultilineText.of(postDto.getContent())
        );

        postRepository.save(post);

        return new PostDto(post);
    }

    public PostDto update(String id, PostDto postDto) {
        Post post = postRepository.findPost(id);
        post.update(postDto.getTitle(), postDto.getContent());
        postRepository.update(post);
        return new PostDto(post);
    }

    public PostDto delete(String id) {
        Post post = postRepository.findPost(id);
        postRepository.delete(post);
        return new PostDto(post);
    }
}
