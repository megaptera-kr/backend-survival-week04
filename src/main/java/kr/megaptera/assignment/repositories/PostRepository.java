package kr.megaptera.assignment.repositories;

import kr.megaptera.assignment.exceptions.PostNotFound;
import kr.megaptera.assignment.models.Post;
import kr.megaptera.assignment.models.PostId;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PostRepository {

    private final Map<PostId, Post> posts;

    // 생성자 (이번 주차 과제에서는 외부 주입 없이 내부에서 생성하도록 함)
    public PostRepository() {
        // PostId class는 Hashable하므로 HashMap의 key object로 정의 가능
        this.posts = new HashMap<>();
    }

    // 전체 게시물 보기
    public List<Post> findAll() {
        return new ArrayList<>(posts.values());
    }

    // 특정 게시물 보기
    public Post find(String id) {
        Post post = posts.get(PostId.of(id));
        if (post == null)
            throw new PostNotFound();
        return post;
    }

    // 게시물 저장하기
    public Post save(Post post) {
        posts.put(post.id(), post);
        return post;
    }

    // 게시물 삭제하기
    public Post delete(String id) {
        return posts.remove(PostId.of(id));
    }
}
