package kr.megaptera.assignment.application;

import kr.megaptera.assignment.dtos.CommentDto;
import kr.megaptera.assignment.models.Comment;
import kr.megaptera.assignment.models.CommentId;
import kr.megaptera.assignment.models.PostId;
import kr.megaptera.assignment.repositories.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    public List<CommentDto> getCommentDtos(String postId) {
        List<Comment> comments = commentRepository.findByPostId(postId);
        return comments.stream().map(comment -> new CommentDto(comment)).toList();
    }

    public CommentDto addCommentDto(String postId, CommentDto commentDto) {
        commentDto.setPostId(postId);
        Comment comment = new Comment(PostId.of(commentDto.getPostId()), commentDto.getAuthor(), commentDto.getContent());
        commentRepository.save(comment);
        return new CommentDto(comment);
    }

    public CommentDto updateCommentDto(String id, String postId, CommentDto commentDto) {
        Comment comment = commentRepository.find(CommentId.of(id));
        comment.update(commentDto.getContent());
        return new CommentDto(comment);
    }

    public CommentDto removeCommentDto(String id) {
        Comment comment = commentRepository.find(CommentId.of(id));
        commentRepository.delete(CommentId.of(id));
        return new CommentDto(comment);
    }
}
