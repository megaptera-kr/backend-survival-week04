package kr.megaptera.assignment.repositories;

import kr.megaptera.assignment.domains.Post;
import kr.megaptera.assignment.domains.PostId;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PostRepository {
    Map<PostId, Post> posts;

    public PostRepository() {
        this.posts = new HashMap<>();
    }

    public List<Post> findAll() {
        return new ArrayList<>(posts.values());
    }

    public Post find(PostId id) {
        Post post = posts.get(id);

        return post;
    }

    public void save(Post post) {
        posts.put(post.id(), post);
    }

    public void delete(PostId id) {
        posts.remove(id);
    }
}