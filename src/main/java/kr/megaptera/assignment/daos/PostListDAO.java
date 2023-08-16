package kr.megaptera.assignment.daos;

import kr.megaptera.assignment.dtos.PostDto;
import kr.megaptera.assignment.exceptions.PostNotFound;

import java.util.ArrayList;
import java.util.List;

public class PostListDAO implements PostDAO {
    private final List<PostDto> postDtos;

    public PostListDAO(){
        this.postDtos = new ArrayList<>();

        this.postDtos.add(new PostDto("1", "제목", "song", "테스트입니다"));
        this.postDtos.add(new PostDto("2", "2등", "park",  "2등이다!!"));
    }

    @Override
    public List<PostDto> findALL() {
        return new ArrayList<>(postDtos);
    }

    @Override
    public PostDto find(String id) {
        return postDtos.stream()
                .filter(post -> post.getId().equals(id))
                .findFirst()
                .orElseThrow(PostNotFound::new);
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
