package kr.megaptera.assignment.daos;

import kr.megaptera.assignment.dtos.PostDto;

import java.util.List;

public interface PostDAO {
    List<PostDto> findALL();

    PostDto find(String id);

    void save(PostDto postDto);

    void delete(String id);
}
