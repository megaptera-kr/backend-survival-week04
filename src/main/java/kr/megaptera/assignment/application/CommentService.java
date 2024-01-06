package kr.megaptera.assignment.application;

import kr.megaptera.assignment.dtos.CommentCreateDto;
import kr.megaptera.assignment.dtos.CommentDto;
import kr.megaptera.assignment.dtos.CommentUpdateDto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class CommentService {

    private Map<String, List<CommentDto>> commentDtos = new HashMap<>();

    public List<CommentDto> getCommentDtos(String postId) {
        List<CommentDto> list = commentDtos.getOrDefault(postId, new ArrayList<>());

        return list;
    }

    public CommentDto createCommentDto(String postId, CommentCreateDto commentCreateDto) {
        CommentDto commentDto = new CommentDto(
                generateId(),
                commentCreateDto.getAuthor(),
                commentCreateDto.getContent()
        );

        if (commentDtos.get(postId) == null) {
            commentDtos.put(postId, new ArrayList<CommentDto>());
        }

        commentDtos.get(postId).add(commentDto);

        return commentDto;
    }

    public CommentDto updateCommentDto(String id, String postId, CommentUpdateDto commentUpdateDto) {
        CommentDto commentDto = findCommentDto(id, postId);

        commentDto.setContent(commentUpdateDto.getContent());

        return commentDto;
    }

    public CommentDto deleteCommentDto(String id, String postId) {
        CommentDto commentDto = findCommentDto(id, postId);

        commentDtos.get(postId).remove(commentDto);

        return commentDto;
    }

    private CommentDto findCommentDto(String id, String postId) {
        return commentDtos.get(postId).stream()
                .filter(comment -> comment.getId().equals(id))
                .findFirst()
                .get();
    }

    private String generateId() {
        // TODO: TSID 도입
        return UUID.randomUUID().toString();
    }
}
