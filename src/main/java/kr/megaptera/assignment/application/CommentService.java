package kr.megaptera.assignment.application;

import kr.megaptera.assignment.domains.MultilineText;
import kr.megaptera.assignment.domains.comment.Comment;
import kr.megaptera.assignment.domains.post.PostId;
import kr.megaptera.assignment.dtos.CommentDto;
import kr.megaptera.assignment.repositories.CommentRepository;

import java.util.ArrayList;
import java.util.List;

public class CommentService {

    CommentRepository commentRepository;

    public CommentService() {
        this.commentRepository = new CommentRepository();
    }


    public List<CommentDto> findAll(String postId) {
        List<Comment> comments = commentRepository.list(new PostId(postId));
        if(comments == null){
            return new ArrayList<>();
        }
        return comments.stream()
            .map(comment -> new CommentDto(comment)).toList();
    }

    public CommentDto create(String postId, CommentDto reqBody) {
        Comment comment = commentRepository.create(new PostId(postId),reqBody);
        return  new CommentDto(comment);
    }

    public CommentDto update(String id, String postId, CommentDto reqBody) {
        List<Comment> list = commentRepository.list(new PostId(postId));
        Comment comment = list.stream()
            .filter(i -> i.id().toString().equals(id))
            .findFirst()
            .get();
        comment.update(
            new MultilineText(reqBody.getContent())
        );

        return new CommentDto(comment);
    }

    public CommentDto delete(String id, String postId) {
        List<Comment> list = commentRepository.list(new PostId(postId));
        Comment comment = list.stream()
            .filter(i -> i.id().toString().equals(id))
            .findFirst()
            .get();

        list.remove(comment);

        CommentDto result = new CommentDto(comment);
        return result;
    }
}
