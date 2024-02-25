package kr.megaptera.assignment.application;

import kr.megaptera.assignment.models.Post;
import kr.megaptera.assignment.repositories.PostRepository;

import java.util.List;

public class PostService {
    private final PostRepository postRepository;

    public PostService() {
        postRepository = new PostRepository();
    }

    public List<Post> getPosts(){
        return postRepository.getPosts();
    }

    public Post getPost(String id){
        return postRepository.getPost(id);
    }

    public Post postPost(String title, String author, String content) {
        return postRepository.postPost(title, author, content);
    }

    public Post patchPost(String id, String title, String content) {
        return postRepository.patchPost(id, title, content);
    }

    public Post deletePost(String id) {
        return postRepository.deletePost(id);
    }
}
