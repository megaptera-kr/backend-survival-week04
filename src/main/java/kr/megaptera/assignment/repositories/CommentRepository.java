package kr.megaptera.assignment.repositories;

import kr.megaptera.assignment.exceptions.NotFoundException;
import kr.megaptera.assignment.models.Comment;
import kr.megaptera.assignment.models.CommentId;
import kr.megaptera.assignment.models.PostId;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CommentRepository {

    private List<Comment> commentList = new ArrayList<>();
    private int nowId = 1;


    public Optional<Comment> findByCommentId(CommentId commentId) {
        return commentList.stream().filter(o -> o.isEqualId(commentId)).findFirst();
    }

    public List<Comment> findAllByPostId(PostId postId) {
        List<Comment> findCommentList = new ArrayList<>();
        for (Comment comment : commentList) {
            if (comment.isEqualPostId(postId)) {
                findCommentList.add(comment);
            }
        }
        return findCommentList;
    }

    public Comment saveComment(Comment comment) {
        comment.createId(CommentId.of(nowId));
        commentList.add(comment);
        return comment;
    }

    public Comment updateComment(Comment comment) {
        int index = findIndex(comment.Id());
        commentList.set(index, comment);
        return comment;
    }

    public void deleteComment(CommentId commentId) {
        int index = findIndex(commentId);
        commentList.remove(index);
    }


    protected int findIndex(CommentId commentId) {
        for (int i = 0; i <commentList.size(); i++) {
            if (commentList.get(i).isEqualId(commentId)) {
                return i;
            }
        }
        throw new NotFoundException();
    }
}
