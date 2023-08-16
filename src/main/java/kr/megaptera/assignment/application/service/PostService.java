package kr.megaptera.assignment.application.service;

import kr.megaptera.assignment.application.domain.Post;
import kr.megaptera.assignment.application.domain.PostId;
import kr.megaptera.assignment.dtos.PostCreateRequestDTO;
import kr.megaptera.assignment.dtos.PostCreateResponseDTO;
import kr.megaptera.assignment.dtos.PostDeleteResponseDTO;
import kr.megaptera.assignment.dtos.PostGetResponseDTO;
import kr.megaptera.assignment.dtos.PostUpdateRequestDTO;
import kr.megaptera.assignment.dtos.PostUpdateResponseDTO;
import kr.megaptera.assignment.repositories.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public List<PostGetResponseDTO> list() {
        List<Post> posts = postRepository.findAll();
        return posts.stream().map(PostGetResponseDTO::from).toList();
    }

    public PostGetResponseDTO get(String id) {
        PostId postId = PostId.of(id);
        Post post = postRepository.findById(postId);
        return PostGetResponseDTO.from(post);
    }


    public PostCreateResponseDTO create(PostCreateRequestDTO requestDTO) {
        Post post = postRepository.save(requestDTO.toEntity());
        return PostCreateResponseDTO.from(post);
    }
    public PostUpdateResponseDTO update(String id, PostUpdateRequestDTO requestDTO) {
        PostId postId = PostId.of(id);
        Post post = postRepository.findById(postId);
        post.update(requestDTO);
        return PostUpdateResponseDTO.from(post);
    }

    public PostDeleteResponseDTO delete(String id) {
        PostId postId = PostId.of(id);
        Post deletedPost = postRepository.delete(postId);
        return PostDeleteResponseDTO.from(deletedPost);
    }
}
