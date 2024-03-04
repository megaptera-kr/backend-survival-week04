package kr.megaptera.assignment.repositories;

import kr.megaptera.assignment.dtos.CommentDto;
import kr.megaptera.assignment.models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CommentRepository {
    private List<Comment> comments;

    public CommentRepository() {
        this.comments = new ArrayList<>();
    }

    public List<Comment> getComments() {
        return comments;
    }

    public Comment getComment(CommentId commentId){
        return comments.stream()
                .filter(comment -> comment.id().equals(commentId)).findFirst()
                .orElse(null);
    }

    public Comment postComment(String postId, CommentDto commentDto) {
        Comment addComment = new Comment(PostId.of(postId)
                , Author.of(commentDto.getAuthor())
                , CommentContent.of(commentDto.getContent()));
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