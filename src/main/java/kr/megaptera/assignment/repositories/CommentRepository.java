package kr.megaptera.assignment.repositories;

import kr.megaptera.assignment.dto.CommentDto;
import kr.megaptera.assignment.models.Comment;
import kr.megaptera.assignment.models.CommentId;
import kr.megaptera.assignment.models.PostId;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommentRepository {
    private Map<CommentId, Comment> comments;

    public CommentRepository() {
        comments = new HashMap<CommentId, Comment>();
    }

    public List<Comment> findAllComments(PostId postid) {
        List<Comment> commentList =  comments.values().stream().filter(comment -> comment.postId().equals(postid)).toList();
        System.out.println("findcomment : " + commentList);
        return commentList;
    }

    public void save(Comment comment) {
        comments.put(comment.id(), comment);
    }

    public Comment find(CommentId commentId) {
        return comments.get(commentId);
    }

    public Comment remove(CommentId commentId) {
        Comment comment = comments.remove(commentId);
        return comment;
    }
}
