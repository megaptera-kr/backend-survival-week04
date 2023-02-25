package kr.megaptera.assignment.application;

import kr.megaptera.assignment.dtos.PostCreateRequestDto;
import kr.megaptera.assignment.dtos.PostResponseDto;
import kr.megaptera.assignment.dtos.PostUpdateRequestDto;
import kr.megaptera.assignment.repositories.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
  private final PostRepository postRepository;

  public PostService(PostRepository postRepository) {
    this.postRepository = postRepository;
  }

  public List<PostResponseDto> getPosts() {
    return postRepository.getPosts();
  }

  public PostResponseDto getPostDatail(String id) {
    return postRepository.getPostDatail(id);
  }

  public PostResponseDto addPost(PostCreateRequestDto postCreateRequestDto) {
    return postRepository.addPost(postCreateRequestDto);
  }

  public PostResponseDto editPost(String id, PostUpdateRequestDto postUpdateRequestDto) {
    if (!postRepository.checkExists(id)) {
      return null;
    }

    return postRepository.editPost(id, postUpdateRequestDto);
  }

  public PostResponseDto deletePost(String id) {
    if (!postRepository.checkExists(id)) {
      return null;
    }
    return postRepository.deletePost(id);
  }
}
