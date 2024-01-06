package kr.megaptera.assignment.application;

import kr.megaptera.assignment.dtos.PostCreateDto;
import kr.megaptera.assignment.dtos.PostDto;
import kr.megaptera.assignment.dtos.PostUpdateDto;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PostService {

    private List<PostDto> postDtos = new ArrayList<>();

    public List<PostDto> getPostDtos() {
        return postDtos;
    }

    public PostDto getPostDto(String id) {
        return findPostDto(id);
    }

    public PostDto createPostDto(PostCreateDto postCreateDto) {
        PostDto postDto = new PostDto(
                generateId(),
                postCreateDto.getTitle(),
                postCreateDto.getAuthor(),
                postCreateDto.getContent()
        );

        postDtos.add(postDto);

        return postDto;
    }

    public PostDto updatePostDto(String id, PostUpdateDto postUpdateDto) {
        PostDto postDto = findPostDto(id);

        postDto.setTitle(postUpdateDto.getTitle());
        postDto.setContent(postUpdateDto.getContent());

        return postDto;
    }

    public PostDto deletePostDto(String id) {
        PostDto postDto = findPostDto(id);

        postDtos.remove(postDto);

        return postDto;
    }

    private PostDto findPostDto(String id) {
        return postDtos.stream()
                .filter(post -> post.getId().equals(id))
                .findFirst()
                .get();
    }

    private String generateId() {
        //TODO: TSID 도입
        return UUID.randomUUID().toString();
    }
}
