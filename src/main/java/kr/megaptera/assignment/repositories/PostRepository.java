package kr.megaptera.assignment.repositories;

import kr.megaptera.assignment.exceptions.PostNotFoundException;
import kr.megaptera.assignment.models.Post;
import kr.megaptera.assignment.models.PostId;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PostRepository {
    private final Map<PostId, Post> posts;

    public PostRepository() {
        this.posts = new HashMap<PostId, Post>();
    }

    public List<Post> findAll() {
        return new ArrayList<>(posts.values());
    }


    public Post find(PostId id) {
        Post post = posts.get(id);
        if(post == null) {
            throw new PostNotFoundException();
        }
        return post;
    }

    public void save(Post post) {
        posts.put(post.id(), post);
    }

//    public void update(PostId id, Post post) {
//        Post targetPost = posts.get(id);
//        if (targetPost == null) {
//            throw new PostNotFoundException();
//        }
//        posts.put(post.id(), post);
//    }

    public void delete(PostId id) {
        posts.remove(id);
    }
}
