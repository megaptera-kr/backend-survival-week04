package kr.megaptera.assignment.daos;

import kr.megaptera.assignment.dtos.PostDto;
import kr.megaptera.assignment.dtos.request.RqCreatePostDto;
import kr.megaptera.assignment.dtos.request.RqUpdatePostDto;

import java.util.List;

public interface PostDAO {
    List<PostDto> getPostList();

    PostDto getPostById(int postId);

    PostDto createPost(RqCreatePostDto dto);

    PostDto updatePost(RqUpdatePostDto dto, int postId);

    PostDto deletePost(int postId);
}
