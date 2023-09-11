package kr.megaptera.assignment.repositories;

import kr.megaptera.assignment.models.Post;
import kr.megaptera.assignment.models.PostId;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PostRepository {
    private final Map<PostId, Post> posts;

    public PostRepository() {
        posts = new HashMap<PostId, Post>();
    }

    public List<Post> findAll() {
        return new ArrayList<>(posts.values());
    }

    public Post find(PostId postId) {
        Post post = posts.get(postId);

        return post;
    }

    public void save(Post post) {
        posts.put(post.id(), post);
    }

    public void delete(PostId postId) {
        posts.remove(postId);
    }
}
