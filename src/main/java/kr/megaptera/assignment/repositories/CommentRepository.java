package kr.megaptera.assignment.repositories;

import kr.megaptera.assignment.models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CommentRepository {
    private List<Comment> comments;

    public CommentRepository() {
        this.comments = new ArrayList<Comment>();
    }

    public List<Comment> getComments() {
        return comments;
    }

    public Comment getComment(CommentId commentId){
        return comments.stream()
                .filter(comment -> comment.id().equals(commentId)).findFirst()
                .orElse(null);
    }

    public Comment postComment(String postId, String author, String content) {
        Comment addComment = new Comment(PostId.of(postId), Author.of(author), CommentContent.of(content));
        comments.add(addComment);
        return addComment;
    }

    public void patchComment(Comment patchComment) {
        comments.stream().filter(comment -> comment.id().equals(patchComment.id()))
                .findFirst()
                .ifPresent(comment -> comment.applyPatch(patchComment));
    }

    public void deleteComment(Comment originComment) {
        comments = comments.stream()
                .filter(comment -> !comment.id().equals(originComment.id()))
                .collect(Collectors.toList());
    }
}