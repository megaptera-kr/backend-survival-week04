package kr.megaptera.assignment.application;

import kr.megaptera.assignment.dtos.CommentDto;
import kr.megaptera.assignment.dtos.PostDto;
import kr.megaptera.assignment.models.Comment;
import kr.megaptera.assignment.models.CommentId;
import kr.megaptera.assignment.models.MultilineText;
import kr.megaptera.assignment.models.Post;
import kr.megaptera.assignment.models.PostId;
import kr.megaptera.assignment.repositories.CommentRepository;
import kr.megaptera.assignment.repositories.PostRepository;

import java.util.ArrayList;
import java.util.List;

public class CommentService {

    private final CommentRepository commentRepository;


    public CommentService() {
        commentRepository = new CommentRepository();
    }

    public List<CommentDto> getCommentDto(String postId) {
        List<CommentDto> commentDtos = new ArrayList<>();

        List<Comment> comments = commentRepository.findAll(PostId.of(postId));

        if (comments.size() > 0) {
            comments.stream().forEach(i -> {
                CommentDto cmtDto = new CommentDto(i.id().toString(), i.author(), i.content().toString());
                commentDtos.add(cmtDto);
            });
        }

        return commentDtos;
    }


    public CommentDto createComment(CommentDto commentDto, String postId) {

        Comment comment = new Comment(
                PostId.of(postId),
                commentDto.getAuthor(),
                MultilineText.of(commentDto.getContent())
        );

        commentRepository.save(comment);

        return new CommentDto(
                comment.id().toString(),
                comment.author(),
                comment.content().toString()
        );

    }

    public CommentDto updateComment(String id, CommentDto commentDto) {
        Comment comment = commentRepository.find(CommentId.of(id));
        comment.update(
                MultilineText.of(commentDto.getContent())
        );

        Comment newComment = commentRepository.find(CommentId.of(id));

        return new CommentDto(
                newComment.id().toString(),
                newComment.author(),
                newComment.content().toString()
        );
    }

    public CommentDto deleteComment(String id) {

        Comment comment = commentRepository.find(CommentId.of(id));
        commentRepository.delete(CommentId.of(id));

        return new CommentDto(
                comment.id().toString(),
                comment.author(),
                comment.content().toString()
        );

    }

}
