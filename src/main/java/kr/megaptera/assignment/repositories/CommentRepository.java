package kr.megaptera.assignment.repositories;

import kr.megaptera.assignment.models.Comment;
import kr.megaptera.assignment.models.Post;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommentRepository {

    // 여기선 Map의 key 가 postId라고 생각을 해야한다.
    private final Map<String, Map<String,Comment>> comments;

    public CommentRepository() {
        this.comments = new HashMap<String,Map<String,Comment>>();
    }

    public List<Comment> findByPostId(String postId) {
        return new ArrayList<>(comments.get(postId).values());
    }

    public Comment findComment(String postId,String commentId) {
        return comments.get(postId).get(commentId);
    }

    public void save(String postId,Comment comment) {
        Map<String, Comment> map = new HashMap<>();
        map.put(comment.id(),comment);
        comments.put(postId, map);
    }


    public void delete(String postId, String id) {
        comments.get(postId).remove(id);
        if(comments.get(postId) == null) {
            comments.remove(postId);
        }
    }

}
