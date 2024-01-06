package kr.megaptera.assignment.daos.post;

import kr.megaptera.assignment.dtos.post.PostDto;

import java.util.ArrayList;
import java.util.List;

public class PostListDAO implements PostDAO {

    private final List<PostDto> postDtos;

    public PostListDAO() {
        postDtos = new ArrayList<>();
    }

    @Override
    public List<PostDto> findAll() {
        return new ArrayList<>(postDtos);
    }

    @Override
    public PostDto find(String id) {
        return postDtos.stream()
                .filter(post -> post.getId().equals(id))
                .findFirst()
                .get();
    }

    @Override
    public void save(PostDto postDto) {
        postDtos.add(postDto);
    }

    @Override
    public void delete(String id) {
        PostDto postDto = find(id);
        postDtos.remove(postDto);
    }
}
