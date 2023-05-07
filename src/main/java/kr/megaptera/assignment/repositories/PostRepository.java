package kr.megaptera.assignment.repositories;

import kr.megaptera.assignment.models.MultiLineText;
import kr.megaptera.assignment.models.Post;
import kr.megaptera.assignment.models.PostId;
import kr.megaptera.assignment.models.PostTitle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PostRepository {
    private final Map<PostId, Post> posts;

    public PostRepository() {
        this.posts = new HashMap<PostId, Post>();
        this.posts.put(PostId.of("1"),
                new Post(PostId.of("1"), PostTitle.of("asd"), "pej", MultiLineText.of("테스트입니다")));
        this.posts.put(PostId.of("2"),
                new Post(PostId.of("2"), PostTitle.of("dddd"), "ppp", MultiLineText.of("2등이다")));

    }

    public List<Post> findAll() {
        return new ArrayList<>(posts.values());
    }
}
