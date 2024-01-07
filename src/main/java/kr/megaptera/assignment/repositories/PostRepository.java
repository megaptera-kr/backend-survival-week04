package kr.megaptera.assignment.repositories;

import kr.megaptera.assignment.exceptions.PostNotFoundException;
import kr.megaptera.assignment.models.post.Post;
import kr.megaptera.assignment.models.post.PostContent;
import kr.megaptera.assignment.models.post.PostId;
import kr.megaptera.assignment.models.post.PostTitle;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PostRepository {

    private final Map<PostId, Post> repository = new HashMap<>();

    public List<Post> findAll() {
        return List.copyOf(repository.values());
    }

    public Post findById(PostId postId) {
        Post post = repository.get(postId);
        if (post == null) {
            throw new PostNotFoundException();
        }
        return post;
    }

    public void save(Post post) {
        repository.put(post.id(), post);
    }

    public Post update(PostId postId, PostTitle postTitle, PostContent postContent) {
        Post post = repository.get(postId);
        if (post == null) {
            throw new PostNotFoundException();
        }
        post.update(postTitle, postContent);
        return post;
    }

    public Post delete(PostId id) {
        Post post = repository.remove(id);
        if (post == null) {
            throw new PostNotFoundException();
        }
        return post;
    }
}
