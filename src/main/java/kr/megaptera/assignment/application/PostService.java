package kr.megaptera.assignment.application;

import kr.megaptera.assignment.dtos.posts.CreatePostDto;
import kr.megaptera.assignment.dtos.posts.PostDto;
import kr.megaptera.assignment.dtos.posts.UpdatePostDto;
import kr.megaptera.assignment.exceptions.PostNotFound;
import kr.megaptera.assignment.models.posts.Post;
import kr.megaptera.assignment.repositories.PostRepository;

import java.util.List;

public class PostService {
    private final PostRepository postRepository;

    public PostService() {
        this.postRepository = new PostRepository();
    }

    public PostDto createPost(CreatePostDto createPostDto) {
        Post post = new Post(createPostDto.getTitle(), createPostDto.getAuthor(), createPostDto.getContent());

        this.postRepository.save(post);

        PostDto postDto = PostDto.of(post);

        return postDto;
    }

    public List<PostDto> getPostDtos() {
        List<Post> postList = this.postRepository.findAll();

        return postList.stream().map(PostDto::of).toList();
    }

    public PostDto getPostDto(String id) {
        Post found = this.postRepository.find(id);

        if (found == null) {
            throw new PostNotFound();
        }

        return PostDto.of(found);
    }

    public PostDto updatePost(String postId, UpdatePostDto updatePostDto) {
        Post postToBeUpdated = this.postRepository.find(postId);

        if (postToBeUpdated == null) {
            throw new PostNotFound();
        }

        postToBeUpdated.update(updatePostDto.getTitle(), updatePostDto.getContent());

        return PostDto.of(postToBeUpdated);
    }

    public PostDto removePost(String postId) {
        Post postToBeRemoved = this.postRepository.find(postId);

        if (postToBeRemoved == null) {
            throw new PostNotFound();
        }

        this.postRepository.remove(postToBeRemoved.id().toString());

        return PostDto.of(postToBeRemoved);
    }
}
