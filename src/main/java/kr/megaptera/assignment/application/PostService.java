package kr.megaptera.assignment.application;

import kr.megaptera.assignment.dtos.PostCreateDto;
import kr.megaptera.assignment.dtos.PostDTO;
import kr.megaptera.assignment.models.MultiLineText;
import kr.megaptera.assignment.models.Post;
import kr.megaptera.assignment.models.PostId;
import kr.megaptera.assignment.models.PostUpdateDto;
import kr.megaptera.assignment.repositories.PostRepository;

import java.util.List;


public class PostService {

    private final PostRepository postRepository;

    public PostService() {
        postRepository = new PostRepository();
    }

    public List<PostDTO> getPosts() {
        List<Post> posts = postRepository.findAll();
        return posts.stream().map(PostDTO::new).toList();
    }

    public PostDTO getPost(String id) {
        Post post = postRepository.find(PostId.of(id));
        return new PostDTO(post);
    }

    public PostDTO createPost(PostCreateDto postCreateDto) {
        Post post = new Post(postCreateDto.getTitle(),
                postCreateDto.getAuthor(),
                MultiLineText.of(postCreateDto.getContent()));

        postRepository.save(post);

        return new PostDTO(post);
    }

    public PostDTO updatePost(String id, PostUpdateDto postUpdateDto) {
        Post post = postRepository.find(PostId.of(id));

        post.update(postUpdateDto.getTitle(),
                MultiLineText.of(postUpdateDto.getContent()));

        return new PostDTO(post);
    }

    public PostDTO deletePost(String id) {
        Post post = postRepository.find(PostId.of(id));

        postRepository.delete(PostId.of(id));

        return new PostDTO(post);
    }
}
