package kr.megaptera.assignment.application;

import kr.megaptera.assignment.dtos.posts.PostCreateDTO;
import kr.megaptera.assignment.dtos.posts.PostDetailDTO;
import kr.megaptera.assignment.dtos.posts.PostUpdateDTO;
import kr.megaptera.assignment.exceptions.PostNotFoundException;
import kr.megaptera.assignment.models.MultiLineText;
import kr.megaptera.assignment.models.Post;
import kr.megaptera.assignment.models.PostId;
import kr.megaptera.assignment.models.SingleLineText;
import kr.megaptera.assignment.repositories.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService() {
        this.postRepository = new PostRepository();
    }

    public List<PostDetailDTO> getPostDTOs() {
        List<Post> posts = postRepository.findAll();
        return posts.stream().map(Post::toPostDetailDTO).toList();
    }

    public PostDetailDTO getPostDTO(String id) {
        PostId postId = PostId.of(id);
        Post post = postRepository.find(postId);
        if (post == null){
            throw new PostNotFoundException(postId);
        }
        return post.toPostDetailDTO();
    }

    public PostDetailDTO createPost(PostCreateDTO dto) {
        Post post = Post.create(dto);
        postRepository.save(post);
        return post.toPostDetailDTO();
    }

    public PostDetailDTO updatePost(String id, PostUpdateDTO dto) {
        PostId postId = PostId.of(id);
        Post post = postRepository.find(postId);
        if (post == null) {
            throw new PostNotFoundException(postId);
        }
        post.updateTitleAndContent(SingleLineText.of(dto.title()), MultiLineText.of(dto.content()));
        postRepository.save(post);
        return post.toPostDetailDTO();
    }

    public PostDetailDTO deletePost(String id) {
        PostId postId = PostId.of(id);

        Post post = postRepository.find(postId);
        if (post == null) {
            throw new PostNotFoundException(postId);
        }
        postRepository.delete(postId);
        return post.toPostDetailDTO();
    }
}
