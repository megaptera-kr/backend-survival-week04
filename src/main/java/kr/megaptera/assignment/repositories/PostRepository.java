package kr.megaptera.assignment.repositories;

import kr.megaptera.assignment.domains.MultilineText;
import kr.megaptera.assignment.domains.post.Post;
import kr.megaptera.assignment.domains.post.PostId;
import kr.megaptera.assignment.dtos.PostDto;
import kr.megaptera.assignment.exceptions.PostNotFound;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PostRepository {

    Map<PostId,Post> posts;

    public PostRepository() {
        this.posts = new HashMap<>();
        this.posts.put(new PostId("1"),new Post(
            new PostId("1")
            ,"title"
            ,"author"
            ,new MultilineText("content")));
    }

    public List<Post> findAll() {
        return new ArrayList<>(posts.values());
    }

    public Post findPost(String id) {
        Post post = posts.get(new PostId(id));
        if(post == null){
            throw new PostNotFound();
        }
        return post;
    }

    public PostDto save(Post post) {
        posts.put(post.id(),post);
        return new PostDto(post);
    }
    public void delete(PostId postId) {
        posts.remove(postId);
    }
}
