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

    public Post getPost(String id){
        return posts.get(PostId.of(id));
    }

    public Post postPost(String title, String author, String content) {
        PostId addPostId =  new PostId();
        Post addPost = new Post(    addPostId
                                  , PostTitle.of(title)
                                  , Author.of(author)
                                  , PostContent.of(content));
        posts.put(addPostId, addPost);
        return addPost;
    }

    public Post patchPost(String id, String title, String content) {
        PostId postId = PostId.of(id);
        Post beforePost = posts.get(postId);
        posts.put(postId, new Post(postId, PostTitle.of(title), beforePost.author(), PostContent.of(content)));
        return posts.get(postId);
    }

    public Post deletePost(String id) {
        PostId deletePostId = PostId.of(id);
        Post deletePost = posts.get(deletePostId);
        posts.remove(deletePostId);
        return deletePost;
    }
}
