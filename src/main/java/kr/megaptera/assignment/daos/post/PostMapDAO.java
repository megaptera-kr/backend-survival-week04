package kr.megaptera.assignment.daos.post;

import kr.megaptera.assignment.dtos.post.PostDto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PostMapDAO implements PostDAO {

    private final Map<String, PostDto> postDtos;

    public PostMapDAO() {
        postDtos = new HashMap<>();
    }

    @Override
    public List<PostDto> findAll() {
        return new ArrayList<>(postDtos.values());
    }

    @Override
    public PostDto find(String id) {
        return postDtos.get(id);
    }

    @Override
    public void save(PostDto postDto) {
        postDtos.put(postDto.getId(), postDto);
    }

    @Override
    public void delete(String id) {
        postDtos.remove(id);
    }
}
