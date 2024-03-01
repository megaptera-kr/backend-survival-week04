package kr.megaptera.assignment.application;

import kr.megaptera.assignment.dtos.PostDto;
import kr.megaptera.assignment.models.*;
import kr.megaptera.assignment.repositories.PostRepository;

import java.util.List;
import java.util.Map;

public class PostService {
    private final PostRepository postRepository;

    public PostService() {
        postRepository = new PostRepository();
    }

    public List<PostDto> getPosts(){
        List<PostDto> postDtos = postRepository.getPosts().stream().map(PostDto::new).toList();
        return postDtos;
    }

    public PostDto getPost(String id){
        return new PostDto(postRepository.getPost(new PostId(id)));
    }

    public PostDto postPost(PostDto post) {
        Post addPost = new Post(new PostId()
                , PostTitle.of(post.getTitle())
                , Author.of(post.getAuthor())
                , PostContent.of(post.getContent()));
        postRepository.postPost(addPost);
        return new PostDto(addPost);
    }

    public PostDto patchPost(String id, PostDto post) {
        Post patchPost = new Post(postRepository.getPost(PostId.of(id))
                , PostTitle.of(post.getTitle())
                , PostContent.of(post.getContent()));
        postRepository.patchPost(patchPost);
        return new PostDto(patchPost);
    }

    public PostDto deletePost(String id) {
        Post deletePost = postRepository.getPost(PostId.of(id));
        postRepository.deletePost(deletePost);
        return new PostDto(deletePost);
    }
}
