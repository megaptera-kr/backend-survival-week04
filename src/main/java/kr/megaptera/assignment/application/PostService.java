package kr.megaptera.assignment.application;

import kr.megaptera.assignment.model.MultiLineText;
import kr.megaptera.assignment.model.Post;
import kr.megaptera.assignment.model.PostId;
import kr.megaptera.assignment.dto.PostDto;
import kr.megaptera.assignment.model.SingleLineText;
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

    public PostDto createPostDto(PostDto postDto) { // MultilineText.of(postDto.getContent()
        Post post = new Post(SingleLineText.of(postDto.getTitle()),
                SingleLineText.of(postDto.getAuthor()),
                MultiLineText.of(postDto.getContent())
        );
        postRepository.save(post);
        return new PostDto(post);
    }

    public PostDto updatePostDto(String id, PostDto postDto) {
        Post post = postRepository.find(PostId.of(id));
        post.update(
                SingleLineText.of(postDto.getTitle()),
                SingleLineText.of(postDto.getAuthor()),
                MultiLineText.of(postDto.getContent())
        );

        return new PostDto(post);
    }

    public PostDto deletePostDto(String id) {
        Post post = postRepository.remove(PostId.of(id));

        return new PostDto(post);
    }
}
