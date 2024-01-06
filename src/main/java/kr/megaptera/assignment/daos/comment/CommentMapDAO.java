package kr.megaptera.assignment.daos.comment;

import kr.megaptera.assignment.dtos.comment.CommentDto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommentMapDAO implements CommentDAO {

    private Map<String, List<CommentDto>> commentDtos = new HashMap<>();

    public CommentMapDAO() {
        commentDtos = new HashMap<>();
    }

    @Override
    public List<CommentDto> findAll(String postId) {
        List<CommentDto> commentDtoList = commentDtos.getOrDefault(postId, new ArrayList<>());

        return commentDtoList;
    }

    @Override
    public CommentDto find(String id, String postId) {
        return commentDtos.get(postId).stream()
                .filter(comment -> comment.getId().equals(id))
                .findFirst()
                .get();
    }

    @Override
    public void save(String postId, CommentDto commentDto) {
        if (commentDtos.get(postId) == null) {
            commentDtos.put(postId, new ArrayList<CommentDto>());
        }

        commentDtos.get(postId).add(commentDto);
    }

    @Override
    public void delete(String postId, CommentDto commentDto) {
        commentDtos.get(postId).remove(commentDto);
    }
}
