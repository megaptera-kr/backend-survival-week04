package kr.megaptera.assignment.repositories;

import kr.megaptera.assignment.exceptions.*;
import kr.megaptera.assignment.model.post.*;

import java.util.*;

public class PostRepository {
    private Map<PostId, Post> posts;

    public PostRepository() {
        this.posts = new HashMap<>();
    }

    public List<Post> findall() {
        return new ArrayList<>(posts.values());
    }

    public Post find(String id) {
        Post post = posts.get(PostId.of(id));

        if (post == null) {
            throw new PostNotFound();
        }
        return post;
    }

    public void save(Post post) {
        posts.put(post.id(), post);
    }

    public void delete(Post post) {
        posts.remove(post.id());
    }
}
