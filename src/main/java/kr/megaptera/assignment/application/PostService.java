package kr.megaptera.assignment.application;

import kr.megaptera.assignment.dtos.PostCreateDto;
import kr.megaptera.assignment.dtos.PostDeleteDto;
import kr.megaptera.assignment.dtos.PostDto;
import kr.megaptera.assignment.dtos.PostUpdateDto;
import kr.megaptera.assignment.repositories.PostRepository;

import java.util.List;

public class PostService {

    private final PostRepository postRepository;

    public PostService(){postRepository = new PostRepository();}

    public List<PostDto> getPostDtos() {
    }

    public PostDto getPostDto() {
    }

    public PostDto createPost(PostCreateDto postCreateDto) {
    }

    public PostDto updatePost(PostUpdateDto postUpdateDto) {
    }

    public PostDto deletePost(PostDeleteDto postDeleteDto) {
        PostDto postDto = null;
        return postDto;
    }
}
