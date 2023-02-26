package kr.megaptera.assignment.application;

import kr.megaptera.assignment.dtos.PostDto;
import kr.megaptera.assignment.models.MultilineText;
import kr.megaptera.assignment.models.Post;
import kr.megaptera.assignment.models.PostId;
import kr.megaptera.assignment.repositories.PostRepository;

import java.util.List;

public class PostService {

    private final PostRepository postRepository;


    public PostService() {
        postRepository = new PostRepository();
    }


    public List<PostDto> getPosts() {
        List<Post> posts = postRepository.findAll();

        return posts.stream().map(post -> new PostDto(post)).toList();
    }

    public PostDto getPostDto(String id) {
        Post post = postRepository.find(PostId.of(id));

        return new PostDto(post);
    }


    public PostDto createPost(PostDto postDto) {
        Post post = new Post(
                postDto.getTitle(),
                postDto.getAuthor(),
                MultilineText.of(postDto.getContent())
        );

        postRepository.save(post);


        return new PostDto(
                post.id().toString(),
                post.title(),
                post.author(),
                post.content().toString()
        );

    }

    public PostDto updatePost(String id, PostDto postDto) {
        Post post = postRepository.find(PostId.of(id));
        post.update(
                postDto.getTitle(),
                postDto.getAuthor(),
                MultilineText.of(postDto.getContent())
        );

        Post newPost = postRepository.find(PostId.of(id));

        return new PostDto(newPost);
    }

    public PostDto deletePost(String id) {

        Post post = postRepository.find(PostId.of(id));
        postRepository.delete(PostId.of(id));

        return new PostDto(post);

    }

}
