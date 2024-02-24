package kr.megaptera.assignment.repositories;

import kr.megaptera.assignment.models.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PostRepository {
    private final Map<PostId, Post> posts;
    public PostRepository() {
        this.posts = new HashMap<>();
        posts.put(PostId.of("1")
                , new Post(PostId.of("1")
                        , PostTitle.of("title")
                        , Author.of("admin")
                        , PostContent.of("content\ntest")));

        posts.put(PostId.of("2")
                , new Post(PostId.of("2")
                        , PostTitle.of("title_TEST")
                        , Author.of("Admin_2")
                        , PostContent.of("contest\nTEST\nTEST2")));
    }

    public List<Post> getPosts() {
        return new ArrayList<>(posts.values());
    }
}
