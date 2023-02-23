package kr.megaptera.assignment.application;

import java.util.ArrayList;
import java.util.List;
import kr.megaptera.assignment.dtos.CreatePostResponse;
import kr.megaptera.assignment.domains.Post;
import kr.megaptera.assignment.dtos.DeletePostResponse;
import kr.megaptera.assignment.dtos.GetPostListResponse;
import kr.megaptera.assignment.dtos.GetPostResponse;
import kr.megaptera.assignment.dtos.UpdatePostRequest;
import kr.megaptera.assignment.dtos.UpdatePostResponse;
import kr.megaptera.assignment.repositories.PostRepository;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public CreatePostResponse createPost(Post post) {
        Post result = postRepository.save(post);

        return new CreatePostResponse(result.getId().toString(),
                result.getTitle(), result.getAuthor(), result.getContent());
    }

    public List<GetPostListResponse> getPosts() {
        List<Post> posts = postRepository.findAll();
        List<GetPostListResponse> response = new ArrayList<>();

        for (Post post : posts) {
            response.add(new GetPostListResponse(post.getId().toString(), post.getTitle(),
                    post.getAuthor(), post.getContent()));
        }

        return response;
    }

    public GetPostResponse getPost(Long id) {
        Post post = postRepository.findById(id);
        return new GetPostResponse(post.getId().toString(), post.getTitle(),
                post.getAuthor(), post.getContent());
    }

    public UpdatePostResponse updatePost(Long id, UpdatePostRequest request) {
        Post post = postRepository.findById(id);

        post.changeTitle(request.getTitle());
        post.changeContent(request.getContent());

        return new UpdatePostResponse(post.getId().toString(), request.getTitle(), post.getAuthor(),
                request.getContent());
    }

    public DeletePostResponse deletePost(Long id) {
        Post post = postRepository.delete(id);

        return new DeletePostResponse(post.getId().toString(), post.getTitle(), post.getAuthor(),
                post.getContent());
    }
}
