package kr.megaptera.assignment.repositories;

import kr.megaptera.assignment.models.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PostRepository {
    private final Map<PostId, Post> posts;
    public PostRepository() {
        this.posts = new HashMap<>();
    }

    public Map<PostId, Post> getPosts() {
        return posts;
    }

    public Post getPost(PostId id){
        return posts.get(id);
    }

    public void postPost(Post post) {
        posts.put(post.id(), post);
    }

    public void patchPost(Post patchPost) {
        posts.put(patchPost.id(), patchPost);
    }

    public void deletePost(Post post) {
        posts.remove(post);
    }
}
