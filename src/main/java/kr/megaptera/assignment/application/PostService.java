package kr.megaptera.assignment.application;

import kr.megaptera.assignment.models.Post;
import kr.megaptera.assignment.models.dtos.PostCreateDto;
import kr.megaptera.assignment.models.dtos.PostDto;
import kr.megaptera.assignment.models.dtos.PostUpdateDto;
import kr.megaptera.assignment.repositories.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;

    // 생성자
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    // 전체 게시물 리스트 가져오기
    public List<PostDto> getPosts() {
        List<Post> posts = postRepository.findAll();
        return posts.stream()
                .map(PostDto::new)
                .toList();
    }

    // 특정 게시물 가져오기
    public PostDto getPost(String id) {
        Post post = postRepository.find(id);
        return new PostDto(post);
    }

    // 게시물 새로 작성하기
    public PostDto createPost(PostCreateDto postCreateDto) {
        Post post = new Post(postCreateDto);
        return new PostDto(postRepository.save(post));
    }

    // 게시물 수정하기
    public PostDto updatePost(String id, PostUpdateDto postUpdateDto) {
        Post post = postRepository.find(id);
        post.updatePost(postUpdateDto);
        return new PostDto(postRepository.save(post));
    }

    // 게시물 삭제하기
    public PostDto deletePost(String id) {
        return new PostDto(postRepository.delete(id));
    }

    // update, delete 남음
    // post로 잘 되면 comment도 도전
}
