package kr.megaptera.assignment.repositories;

import kr.megaptera.assignment.dtos.PostCreateRequestDto;
import kr.megaptera.assignment.dtos.PostResponseDto;
import kr.megaptera.assignment.dtos.PostUpdateRequestDto;
import kr.megaptera.assignment.entities.PostEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;

@Repository
public class PostRepository {
  private Long newId = 0L;

  private List<PostEntity> postEntities = new ArrayList<>();

  public List<PostResponseDto> getPosts() {
    return PostResponseDto.of(postEntities);
  }

  public PostResponseDto getPostDatail(String id) {
    int foundIdx = findIdxById(id);
    PostEntity postEntity = postEntities.get(foundIdx);
    return PostResponseDto.of(postEntity);
  }

  public PostResponseDto addPost(PostCreateRequestDto postCreateRequestDto) {
    PostEntity postEntity =
      new PostEntity(String.valueOf(newId++), postCreateRequestDto.getTitle(),
        postCreateRequestDto.getAuthor(),
        postCreateRequestDto.getContent());
    postEntities.add(postEntity);
    return PostResponseDto.of(postEntity);
  }

  public PostResponseDto editPost(String id, PostUpdateRequestDto postUpdateRequestDto) {
    int foundIdx = findIdxById(id);
    PostEntity postEntity = postEntities.get(foundIdx);
    PostEntity editedPostEntity = new PostEntity(id, postUpdateRequestDto.getTitle(),
      postEntity.getAuthor(), postUpdateRequestDto.getContent());
    postEntities.set(foundIdx, editedPostEntity);
    return PostResponseDto.of(editedPostEntity);
  }

  public PostResponseDto deletePost(String id) {
    int foundIdx = findIdxById(id);
    PostEntity postEntity =
      postEntities.remove(foundIdx);
    return PostResponseDto.of(postEntity);
  }

  private int findIdxById(String id) {
    OptionalInt indexOpt = IntStream.range(0, postEntities.size())
                                    .filter(i -> id.equals(postEntities.get(i).getId()))
                                    .findFirst();
    if (!indexOpt.isPresent()) {
      throw new IllegalArgumentException("don't have that item");
    }
    return indexOpt.getAsInt();
  }

  public boolean checkExists(String id) {
    try {
      findIdxById(id);
    } catch (Exception e) {
      return false;
    }
    return true;
  }
}
