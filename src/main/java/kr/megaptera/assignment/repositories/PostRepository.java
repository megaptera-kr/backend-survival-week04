package kr.megaptera.assignment.repositories;

import com.github.f4b6a3.tsid.TsidCreator;
import kr.megaptera.assignment.models.Post;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class PostRepository {
    private Map<String, Post> posts;

    public PostRepository() {
        posts = new HashMap<>();
    }

    public Post[] findAll() {
        var copiedPosts = posts.values()
                .stream()
                .map(row -> row.clone())
                .toArray(Post[]::new);

        return copiedPosts;
    }

    public Post find(String id) {
        return posts.get(id);
    }

    public void add(Post post){
        posts.put(post.getId(), post);
    }

    public void update(String id, Post post){
        posts.replace(id, post);
    }

    public void remove(String id){
        posts.remove(id);
    }
}
