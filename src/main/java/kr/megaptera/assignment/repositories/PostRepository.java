package kr.megaptera.assignment.repositories;

import kr.megaptera.assignment.domain.Post;
import kr.megaptera.assignment.dtos.Post.PostCreateDto;
import kr.megaptera.assignment.dtos.Post.PostUpdateDto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Repository
public class PostRepository {
    private Long newId = 0L;
    private static List<Post> postStore = new ArrayList<>();

    public List<Post> findAll() {
        return postStore.stream().toList();
    }

    public Post findPost(String id) {
        return postStore.stream().filter(item -> item.getId().equals(id)).findFirst().orElse(null);
    }

    public Post save(Post post) {
        post.setId(createId());
        postStore.add(post);
        return post;
    }

    public Post update(Post post) {
        postStore = postStore.stream().map(item -> item.getId().equals(post.getId()) ? post : item)
                .collect(Collectors.toList());
        return findPost(post.getId());
    }

    private String createId() {
        newId++;
        return newId.toString();
    }

    public Post delete(String id) {
        Post post = postStore.stream().filter(item -> item.getId().equals(id)).findFirst().orElse(null);
        if (post != null) {
            postStore.remove(post);
        }
        return post;
    }
}
