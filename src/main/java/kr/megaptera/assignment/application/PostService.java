package kr.megaptera.assignment.application;

import kr.megaptera.assignment.dtos.PostCreateDto;
import kr.megaptera.assignment.dtos.PostDto;
import kr.megaptera.assignment.models.MultilineText;
import kr.megaptera.assignment.models.Post;
import kr.megaptera.assignment.models.PostId;
import kr.megaptera.assignment.repositories.PostRepository;

import java.util.List;

public class PostService {

    private final PostRepository postRepository;

    public PostService(){
        postRepository = new PostRepository();
    }

    public List<PostDto> getPostDtos(){
        List<Post> posts = postRepository.findALL();

        return posts.stream().map(post -> new PostDto(post)).toList();

    }

    public PostDto getPostDto(String id) {

        Post post = postRepository.find(PostId.of(id));

        return new PostDto((post));
    }

    public PostDto createPost(PostCreateDto PostCreateDto) {

        Post post = new Post(PostCreateDto.getTitle(), PostCreateDto.getAuthor(), MultilineText.of(PostCreateDto.getContent()));

        postRepository.save(post);

        return new PostDto(post);
    }

    public PostDto updatePost(String id, PostDto postDto) {

        Post post = postRepository.find(PostId.of(id));

        post.update(
                postDto.getTitle(),
                MultilineText.of(postDto.getContent())
        );

        return new PostDto(post);
    }

    public PostDto deletePost(String id) {

        Post post = postRepository.find(PostId.of(id));

        postRepository.delete(PostId.of(id));

        return new PostDto(post);
    }


}
