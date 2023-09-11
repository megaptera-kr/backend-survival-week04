package kr.megaptera.assignment.repositories;

import kr.megaptera.assignment.model.MultiLineText;
import kr.megaptera.assignment.model.Post;
import kr.megaptera.assignment.model.PostId;
import kr.megaptera.assignment.model.SingleLineText;
import kr.megaptera.assignment.exception.PostNotFound;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PostRepository {
    Map<PostId, Post> posts;

    public PostRepository() {
        this.posts = new HashMap<>();

        this.posts.put(PostId.of("1"),
                new Post(PostId.of("1"), SingleLineText.of("제목"), SingleLineText.of("작가"), MultiLineText.of("나는\n천재인가\n")));
        this.posts.put(PostId.of("2"),
                new Post(PostId.of("2"), SingleLineText.of("제목2"), SingleLineText.of("작가2"), MultiLineText.of("나는\n바보인가\n")));
    }

    public List<Post> findAll() {
        return new ArrayList<>(posts.values());
    }

    public Post find(PostId id) {
        Post post = posts.get(id);

        if (post == null){
            throw new PostNotFound();
        }
        return post;
    }

    public void save(Post post) {
        posts.put(post.id(), post);
    }
}
