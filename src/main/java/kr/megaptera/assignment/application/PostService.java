package kr.megaptera.assignment.application;

import kr.megaptera.assignment.daos.PostDAO;
import kr.megaptera.assignment.daos.PostListDAO;
import kr.megaptera.assignment.dtos.PostDto;
import kr.megaptera.assignment.dtos.request.RqCreatePostDto;
import kr.megaptera.assignment.dtos.request.RqUpdatePostDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PostService {

    private final PostDAO postDAO;

    public PostService() {
        this.postDAO = new PostListDAO();
    }

    public ResponseEntity<List<PostDto>> getPostList() {
        List<PostDto> postDtoList = postDAO.getPostList();
        return new ResponseEntity<>(postDtoList, HttpStatus.OK);
    }

    public ResponseEntity<PostDto> getPostById(int postId) {
        PostDto postDto = postDAO.getPostById(postId);
        return new ResponseEntity<>(postDto, HttpStatus.OK);
    }

    public ResponseEntity<PostDto> createPost(RqCreatePostDto dto) {
        PostDto postDto = postDAO.createPost(dto);
        return new ResponseEntity<>(postDto, HttpStatus.CREATED);
    }

    public ResponseEntity<PostDto> updatePost(RqUpdatePostDto dto, int postId) {
        PostDto postDto = postDAO.updatePost(dto, postId);
        return new ResponseEntity<>(postDto, HttpStatus.OK);
    }

    public ResponseEntity<PostDto> deletePost(int postId) {
        PostDto postDto = postDAO.deletePost(postId);
        return new ResponseEntity<>(postDto, HttpStatus.OK);
    }
}
