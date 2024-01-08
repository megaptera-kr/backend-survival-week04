package kr.megaptera.assignment.repositories;

import kr.megaptera.assignment.domain.Post;
import kr.megaptera.assignment.exceptions.PostNotFound;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class PostRepository {

    Map<String, Post> postMap;

    public PostRepository() {
        this.postMap = new HashMap<>();
    }

    public Post find(String id) throws PostNotFound {
        Post post = postMap.get(id);

        if (post == null) {
            throw new PostNotFound();
        }
        return post;
    }

    public List<Post> findAll() {
        return new ArrayList<>(postMap.values());
    }

    public void save(Post post) {
        postMap.put(post.getId(), post);
    }

    public void delete(String id) {
        postMap.remove(id);
    }
}
