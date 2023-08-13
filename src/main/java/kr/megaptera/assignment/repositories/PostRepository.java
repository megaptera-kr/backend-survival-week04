package kr.megaptera.assignment.repositories;

import kr.megaptera.assignment.application.domain.Post;
import kr.megaptera.assignment.application.domain.PostId;
import kr.megaptera.assignment.exceptions.PostNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class PostRepository implements CRUDRepository<Post, PostId> {
    private final AtomicLong idFactory = new AtomicLong();
    private final ConcurrentHashMap<PostId, Post> map = new ConcurrentHashMap<>();

    @Override
    public Post save(Post post) {
        PostId postId = new PostId(idFactory.getAndIncrement());
        post.setId(postId);
        map.put(postId, post);
        return post;
    }

    @Override
    public Post findById(PostId postId) {
        Post post = map.get(postId);
        if (Objects.isNull(post)) {
            throw new PostNotFoundException();
        }

        return post;
    }

    @Override
    public boolean exists(PostId postId) {
        Post post = map.get(postId);
        if (Objects.isNull(post)) {
            throw new PostNotFoundException();
        }
        return true;
    }

    @Override
    public List<Post> findAll() {
        return map.values().stream().toList();
    }

    @Override
    public Post delete(PostId postId) {
        Post post = map.get(postId);
        if (Objects.isNull(post)) {
            throw new PostNotFoundException();
        }

        map.remove(postId);
        return post;
    }

    @Override
    public void deleteAll() {
        map.clear();
    }
}
