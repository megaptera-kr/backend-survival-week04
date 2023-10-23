package kr.megaptera.assignment.repositories;

import kr.megaptera.assignment.domains.MultilineText;
import kr.megaptera.assignment.domains.comment.Comment;
import kr.megaptera.assignment.domains.post.PostId;
import kr.megaptera.assignment.dtos.CommentDto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommentRepository {
    Map<PostId, List<Comment>> comments;

    public CommentRepository() {
        this.comments = new HashMap<>();
    }
    public List<Comment> list(PostId postId) {
        return comments.get(postId);
    }

    public Comment create(PostId postId, CommentDto reqBody) {
        List<Comment> commentList = comments.get(postId);
        if(commentList == null){
            commentList = new ArrayList<>();
            comments.put(postId,commentList);
        }

        Comment comment = new Comment(postId,reqBody.getAuthor(),new MultilineText(reqBody.getContent()));
        commentList.add(comment);

        return comment;
    }
}
