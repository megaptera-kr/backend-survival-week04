package kr.megaptera.assignment.daos.post;

import kr.megaptera.assignment.dtos.post.PostDto;

import java.util.List;

public interface PostDAO {

    List<PostDto> findAll();

    PostDto find(String id);

    void save(PostDto postDto);

    void delete(String id);
}
