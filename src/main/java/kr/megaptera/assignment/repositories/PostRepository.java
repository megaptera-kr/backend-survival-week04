package kr.megaptera.assignment.repositories;

import kr.megaptera.assignment.exceptions.PostNotFoundException;
import kr.megaptera.assignment.models.Post.Post;
import kr.megaptera.assignment.models.Post.PostContent;
import kr.megaptera.assignment.models.Post.PostId;
import kr.megaptera.assignment.models.Post.PostTitle;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PostRepository {

    private final Map<PostId, Post> repository = new HashMap<>();

    public List<Post> findAll() {
        // return immutable list
        return List.copyOf(repository.values());
    }

    public Post findById(PostId postId) {
        Post post = repository.get(postId);
        if (post == null) {
            throw new PostNotFoundException();
        }
        // return post
        return post;
    }

    public void save(Post post) {
        // save post
        repository.put(post.id(), post);
    }

    public Post update(PostId postId, PostTitle postTitle, PostContent postContent) {
        // update post
        Post post = repository.get(postId);
        if (post == null) {
            throw new PostNotFoundException();
        }
        post.update(postTitle, postContent);
        return post;
    }

    public Post delete(PostId id) {
        // delete post
        Post post = repository.remove(id);
        if (post == null) {
            throw new PostNotFoundException();
        }
        return post;
    }
}
