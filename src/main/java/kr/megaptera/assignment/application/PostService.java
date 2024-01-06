package kr.megaptera.assignment.application;

import kr.megaptera.assignment.daos.post.PostDAO;
import kr.megaptera.assignment.daos.post.PostMapDAO;
import kr.megaptera.assignment.dtos.post.PostCreateDto;
import kr.megaptera.assignment.dtos.post.PostDto;
import kr.megaptera.assignment.dtos.post.PostUpdateDto;

import java.util.List;
import java.util.UUID;

public class PostService {

    private final PostDAO postDAO;

    public PostService() {
        postDAO = new PostMapDAO();
    }

    public List<PostDto> getPostDtos() {
        return postDAO.findAll();
    }

    public PostDto getPostDto(String id) {
        return postDAO.find(id);
    }

    public PostDto createPostDto(PostCreateDto postCreateDto) {
        PostDto postDto = new PostDto(
                generateId(),
                postCreateDto.getTitle(),
                postCreateDto.getAuthor(),
                postCreateDto.getContent()
        );

        postDAO.save(postDto);

        return postDto;
    }

    public PostDto updatePostDto(String id, PostUpdateDto postUpdateDto) {
        PostDto postDto = postDAO.find(id);

        postDto.setTitle(postUpdateDto.getTitle());
        postDto.setContent(postUpdateDto.getContent());

        return postDto;
    }

    public PostDto deletePostDto(String id) {
        PostDto postDto = postDAO.find(id);

        postDAO.delete(id);

        return postDto;
    }

    private String generateId() {
        //TODO: TSID 도입
        return UUID.randomUUID().toString();
    }
}
