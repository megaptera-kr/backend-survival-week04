package kr.megaptera.assignment.application;

import kr.megaptera.assignment.dtos.CommentDto;
import kr.megaptera.assignment.models.comment.Comment;
import kr.megaptera.assignment.models.comment.CommentAuthor;
import kr.megaptera.assignment.models.comment.CommentContent;
import kr.megaptera.assignment.models.comment.CommentId;
import kr.megaptera.assignment.models.post.PostId;
import kr.megaptera.assignment.repositories.CommentRepository;

import java.util.List;

public class CommentService {

    private final CommentRepository commentRepository;

    public CommentService() {
        this.commentRepository = new CommentRepository();
    }

    public List<CommentDto> list(String postId) {
        // postId로 comments 불러오기
        List<Comment> comments = commentRepository.findAllByPostId(PostId.of(postId));
        // DTO 변환
        return comments.stream()
                .map(CommentDto::new)
                .toList();
    }

    public CommentDto create(String postId, CommentDto commentDto) {

        // comment 생성
        Comment comment = new Comment(
                CommentAuthor.of(commentDto.getAuthor()),
                CommentContent.of(commentDto.getContent())
        );
        // comment 저장
        commentRepository.save(PostId.of(postId), comment);
        // DTO 변환
        return new CommentDto(comment);
    }

    public CommentDto update(String postId, String id, CommentDto commentDto) {
        // comment 수정
        Comment comment = commentRepository.update(
                PostId.of(postId),
                CommentId.of(id),
                CommentContent.of(commentDto.getContent())
        );
        // DTO 변환
        return new CommentDto(comment);
    }

    public CommentDto delete(String postId, String id) {
        Comment comment = commentRepository.delete(
                PostId.of(postId),
                CommentId.of(id)
        );

        return new CommentDto(comment);
    }
}
