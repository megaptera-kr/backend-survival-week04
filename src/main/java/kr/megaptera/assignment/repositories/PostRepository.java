package kr.megaptera.assignment.repositories;

import kr.megaptera.assignment.models.Post;
import kr.megaptera.assignment.models.PostId;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PostRepository {
    private final Map<PostId, Post> postMap;

    public PostRepository() {
        this.postMap = new HashMap<>();
    }

    public List<Post> findAll() {
        return postMap.values().stream().sorted(Comparator.comparing(Post::id)).toList();
    }

    public Post find(PostId id) {
        return postMap.get(id);
    }

    public void save(Post post) {
        postMap.put(post.id(), post);
    }

    public void delete(PostId id) {
        postMap.remove(id);
    }
}
