package kr.megaptera.assignment.application;

import kr.megaptera.assignment.dtos.PostCreateDto;
import kr.megaptera.assignment.dtos.PostDto;
import kr.megaptera.assignment.dtos.PostId;
import kr.megaptera.assignment.dtos.PostUpdateDto;
import kr.megaptera.assignment.models.Post;
import kr.megaptera.assignment.repositories.PostRepository;

import java.util.List;

public class PostService {

    private final PostRepository postRepository;

    public PostService(){postRepository = new PostRepository();}

    public List<PostDto> getPostDtos() {
        List<Post> posts = postRepository.findAll();

            return posts.stream().map(PostDto::new).toList();   //PostDto에 post를 인자로 받는 생성자 추가
    }

    public PostDto getPostDto(String id) {
        Post post = postRepository.find(PostId.of(id));

        return new PostDto(post);
    }

    public PostDto createPost(PostCreateDto postCreateDto) {

        Post post = new Post(
                postCreateDto.getTitle(),
                postCreateDto.getAuthor(),
                postCreateDto.getContent()
        );

        postRepository.save(post);

        return new PostDto(post);
    }

    public PostDto updatePost(String id, PostUpdateDto postUpdateDto) {
        Post post = postRepository.find(PostId.of(id));

        post.setTitle(postUpdateDto.getTitle());    //옅은 복사?
        post.setContent(postUpdateDto.getContent());

        return new PostDto(post);
    }

    public PostDto deletePost(String id) {
        Post post = postRepository.find(PostId.of(id));

        postRepository.delete(PostId.of(id));

        return new PostDto(post);
    }
}
