package kr.megaptera.assignment.repositories;

import kr.megaptera.assignment.dtos.CommentCreateRequestDto;
import kr.megaptera.assignment.dtos.CommentEditRequestDto;
import kr.megaptera.assignment.dtos.CommentResponseDto;
import kr.megaptera.assignment.entities.CommentEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;

@Repository
public class CommentRepository {
  private Long newId = 0L;
  private List<CommentEntity> commentEntities = new ArrayList<>();

  public List<CommentResponseDto> getComments(String postId) {
    List<CommentResponseDto> searchComments = new ArrayList<>();
    for (CommentEntity commentEntity :
      commentEntities) {
      if (postId.equals(commentEntity.getPostId())) {
        searchComments.add(CommentResponseDto.of(commentEntity));
      }
    }
    return searchComments;
  }

  public CommentResponseDto addComment(String postId,
                                       CommentCreateRequestDto commentCreateRequestDto) {
    CommentEntity commentEntity = new CommentEntity(String.valueOf(newId++),
      postId,
      commentCreateRequestDto.getAuthor(),
      commentCreateRequestDto.getContent());
    commentEntities.add(commentEntity);
    return CommentResponseDto.of(commentEntity);
  }

  public CommentResponseDto editComment(String id, String postId,
                                        CommentEditRequestDto commentEditRequestDto) {
    int foundIdx = findIdx(id);
    CommentEntity commentEntity = new CommentEntity(id,
      postId,
      commentEntities.get(foundIdx).getAuthor(),
      commentEditRequestDto.getContent());
    commentEntities.set(foundIdx, commentEntity);
    return CommentResponseDto.of(commentEntity);
  }

  public CommentResponseDto deleteComment(String id) {
    int foundIdx = findIdx(id);
    CommentResponseDto commentResponseDto = CommentResponseDto.of(commentEntities.get(foundIdx));
    commentEntities.remove(foundIdx);
    return commentResponseDto;
  }

  public boolean checkExists(String id) {
    try {
      findIdx(id);
    } catch (Exception e) {
      return false;
    }
    return true;
  }

  private int findIdx(String id) {
    OptionalInt indexOpt = IntStream.range(0, commentDtos.size())
                                    .filter(idx -> id.equals(commentDtos.get(idx).getId()))
                                    .findFirst();
    if (!indexOpt.isPresent()) {
      throw new IllegalArgumentException("don't have that item");
    }
    return indexOpt.getAsInt();
  }
}
