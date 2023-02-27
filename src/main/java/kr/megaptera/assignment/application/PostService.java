package kr.megaptera.assignment.application;

import kr.megaptera.assignment.dtos.post.PostCreateDto;
import kr.megaptera.assignment.dtos.post.PostDto;
import kr.megaptera.assignment.dtos.post.PostUpdateDto;
import kr.megaptera.assignment.repositories.PostRepository;

import java.util.List;

public class PostService {

    private final PostRepository postRepository;

    public PostService() {
        postRepository = new PostRepository();
    }

    // 게시물 전체 조회 메서드
    public List<PostDto> getPostList() {
        return postRepository.findAllPost();
    }

    // 게시물 상세 조회 메서드
    public PostDto getPostDetail(String id) {
        return postRepository.findById(id);
    }

    // 게시물 생성 메서드
    public PostDto createPost(PostCreateDto postCreateDtoDto) {
        return postRepository.createPost(postCreateDtoDto);
    }

    public PostDto updatePost(String id, PostUpdateDto postUpdateDto) {
        return postRepository.updatePost(id, postUpdateDto);
    }

    public PostDto deletePost(String id) {
        return postRepository.deletePost(id);
    }
}
