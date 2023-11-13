package kr.megaptera.assignment.repositories;

import kr.megaptera.assignment.models.posts.Post;
import kr.megaptera.assignment.models.posts.PostId;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PostRepository {
    private Map<PostId, Post> posts;

    public PostRepository() {
        this.posts = new HashMap<>();
    }

    public List<Post> findAll() {
        return new ArrayList<>(this.posts.values());
    }

    public Post find(String id) {
        return this.posts.get(PostId.of(id));
    }

    public void save(Post post) {
        this.posts.put(post.id(), post);
    }

    public void remove(String postId) {
        this.posts.remove(PostId.of(postId));
    }
}
