package kr.megaptera.assignment.repositories;

import kr.megaptera.assignment.models.Post;
import kr.megaptera.assignment.models.PostId;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PostRepository {
    private List<Post> postList = new ArrayList<>();
    private int nowId = 1;

    public List<Post> findAll() {
        return postList;
    }

    public Optional<Post> findById(PostId postId) {
        return postList.stream().filter(o -> o.isEqualId(postId)).findFirst();
    }

    public Post savePost(Post post) {
        post.createId(PostId.of(nowId));
        postList.add(post);
        nowId++;
        return post;
    }
}
