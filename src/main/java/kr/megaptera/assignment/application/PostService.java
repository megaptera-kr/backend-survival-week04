package kr.megaptera.assignment.application;

import kr.megaptera.assignment.models.*;
import kr.megaptera.assignment.repositories.PostRepository;

import java.util.List;
import java.util.Map;

public class PostService {
    private final PostRepository postRepository;

    public PostService() {
        postRepository = new PostRepository();
    }

    public Map<PostId, Post> getPosts(){
        return postRepository.getPosts();
    }

    public Post getPost(String id){
        return postRepository.getPost(PostId.of(id));
    }

    public Post postPost(Post post) {
        Post addPost = new Post(new PostId(), post.title(), post.author(), post.postContent());
        postRepository.postPost(addPost);
        return addPost;
    }

    public Post patchPost(String id, Post post) {
        Post patchPost = new Post(postRepository.getPost(PostId.of(id)), post.title(), post.postContent());
        postRepository.patchPost(patchPost);
        return patchPost;
    }

    public Post deletePost(String id) {
        Post deletePost = postRepository.getPost(PostId.of(id));
        postRepository.deletePost(deletePost);
        return deletePost;
    }
}
