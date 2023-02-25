package kr.megaptera.assignment.repositories;

import kr.megaptera.assignment.dtos.post.PostCreateDto;
import kr.megaptera.assignment.dtos.post.PostDto;
import kr.megaptera.assignment.dtos.post.PostUpdateDto;

import java.util.HashMap;
import java.util.List;

public class PostRepository {
//    List<PostDto> postList = new ArrayList<>();

    // 게시글 아이디를 Key로 가지는 해시맵으로 게시글 관리
    HashMap<String, PostDto> postList = new HashMap<String, PostDto>();

    private Long id = 0L;

    // 아이디 하나씩 커지는 메서드
    private String getNewId() {
        id += 1;
        return id.toString();
    }

    public List<PostDto> findAllPost() {
        return postList.values().stream().toList();
    }

    public PostDto findById(String id) {
        return postList.get(id);
    }

    public PostDto createPost(PostCreateDto postCreateDtoDto) {
        // 새로운 post 생성
        PostDto newPost = new PostDto(getNewId(),
                postCreateDtoDto.getTitle(),
                postCreateDtoDto.getAuthor(),
                postCreateDtoDto.getContent()
        );

        // 목록에 추가
        postList.put(newPost.getId(), newPost);

        return newPost;
    }

    public PostDto updatePost(String id, PostUpdateDto postUpdateDto) {
        // 업데이트 할 게시글 검색
        PostDto updateTargetPost = findById(id);

        // 제목 및 내용 업데이트
        updateTargetPost.setTitle(postUpdateDto.getTitle());
        updateTargetPost.setContent(postUpdateDto.getContent());

        return updateTargetPost;
    }

    public PostDto deletePost(String id) {
        PostDto deleteTargetDto = findById(id);

        postList.remove(deleteTargetDto.getId());

        return deleteTargetDto;
    }
}
