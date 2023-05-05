package kr.megaptera.assignment.repositories;

import kr.megaptera.assignment.dto.PostDto;
import kr.megaptera.assignment.exceptions.PostNotFound;
import kr.megaptera.assignment.models.Post;
import kr.megaptera.assignment.models.PostId;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PostRepository {

    private Map<PostId, Post> posts;

    public PostRepository() {
        posts = new HashMap<PostId, Post>();
    }

    public List<Post> getAll() {
        System.out.println("postmap load"+posts);
        return new ArrayList<Post>(posts.values());
    }

    public void save(Post post) {
        System.out.println("save post : " + post.id());
        posts.put(post.id(), post);
        System.out.println("postmap : " + posts.get(post.id()).toString());
    }

    public Post findPost(PostId id) {
        System.out.println("repository id : " + id);
        Post post = posts.get(id);
        System.out.println("find post" + post);
        if(post == null){
            throw new PostNotFound();
        }
        return post;
    }

    public Post removePost(PostId id) {
        Post post = posts.get(id);
        posts.remove(id);
        return post;
    }
}
