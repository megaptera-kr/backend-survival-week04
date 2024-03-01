package kr.megaptera.assignment.repositories;

import kr.megaptera.assignment.models.Post;
import kr.megaptera.assignment.models.PostId;

import java.util.ArrayList;
import java.util.List;

public class PostRepository {
    private final List<Post> posts;
    public PostRepository() {
        this.posts = new ArrayList<>();
    }

    public List<Post> getPosts() {
        return posts;
    }

    public Post getPost(PostId id){
        Post findPost = posts.stream().filter(post -> post.id().equals(id)).findFirst().orElse(null);
        return findPost;
    }

    public void postPost(Post post) {
        posts.add(post);
    }

    public void patchPost(Post patchPost) {
        posts.add(patchPost);
    }

    public void deletePost(Post post) {
        posts.remove(post);
    }
}
