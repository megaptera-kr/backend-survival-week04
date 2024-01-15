package kr.megaptera.assignment.application;

import kr.megaptera.assignment.dtos.PostDto;
import kr.megaptera.assignment.models.post.Post;
import kr.megaptera.assignment.models.post.PostAuthor;
import kr.megaptera.assignment.models.post.PostContent;
import kr.megaptera.assignment.models.post.PostId;
import kr.megaptera.assignment.models.post.PostTitle;
import kr.megaptera.assignment.repositories.PostRepository;

import java.util.List;

public class PostService {

    private final PostRepository postRepository;

    public PostService() {
        this.postRepository = new PostRepository();
    }

    public List<PostDto> list() {
        List<Post> posts = postRepository.findAll();
        return posts.stream()
                .map(PostDto::new)
                .toList();
    }

    public PostDto detail(String id) {
        Post post = postRepository.findById(PostId.of(id));
        return new PostDto(post);
    }

    public PostDto create(PostDto postDto) {
        Post post = new Post(
                PostTitle.of(postDto.getTitle()),
                PostAuthor.of(postDto.getAuthor()),
                PostContent.of(postDto.getContent())
        );
        postRepository.save(post);
        return new PostDto(post);
    }

    public PostDto update(String id, PostDto postDto) {
        Post post = this.postRepository.update(
                PostId.of(id),
                PostTitle.of(postDto.getTitle()),
                PostContent.of(postDto.getContent())
        );
        return new PostDto(post);
    }

    public PostDto delete(String id) {
        Post post = postRepository.delete(PostId.of(id));
        return new PostDto(post);
    }
}
