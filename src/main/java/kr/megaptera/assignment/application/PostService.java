package kr.megaptera.assignment.application;

import kr.megaptera.assignment.domain.Post;
import kr.megaptera.assignment.dtos.PostDto;
import kr.megaptera.assignment.exceptions.PostNotFound;
import kr.megaptera.assignment.repositories.PostRepository;
import kr.megaptera.assignment.utils.PostUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<PostDto> getPostList() {
        List<Post> posts = postRepository.findAll();

        return posts.stream().map(PostDto::new).toList();
    }

    public PostDto getPost(String id) throws PostNotFound {
        Post post = postRepository.find(id);

        if (post != null) {
            return new PostDto(post);
        } else {
            return null;
        }

    }

    public PostDto createPost(PostDto postDto) {
        log.info("postDto: {}", postDto);
        Post post = Post.builder()
                .id(PostUtil.getId())
                .title(postDto.getTitle())
                .content(postDto.getContent())
                .author(postDto.getAuthor())
                .build();
        postRepository.save(post);

        return new PostDto(post);
    }


    public PostDto updatePost(String id, PostDto postDto) throws PostNotFound {
        Post post = postRepository.find(id);
        post.update(postDto.getTitle(), postDto.getContent());

        return new PostDto(post);
    }

    public PostDto deletePost(String id) throws PostNotFound {
       Post post = postRepository.find(id);
       postRepository.delete(id);

        return new PostDto(post);
    }

}
