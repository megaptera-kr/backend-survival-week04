package kr.megaptera.assignment.repositories;

import java.util.ArrayList;
import java.util.List;
import kr.megaptera.assignment.domains.Post;
import kr.megaptera.assignment.domains.PostId;
import org.springframework.stereotype.Repository;

@Repository
public class PostRepository {

    private final List<Post> posts = new ArrayList<>();

    public List<Post> findAll() {
        return posts;
    }

    public Post findById(PostId postId) {
        return posts.stream()
            .filter(post -> post.isExists(postId))
            .findFirst()
            .get();
    }

    public void save(Post post) {
        posts.add(post);
    }

    public void delete(PostId postId) {
        posts.remove(findById(postId));
    }
}
