package kr.megaptera.assignment.application;

import java.util.ArrayList;
import java.util.List;
import kr.megaptera.assignment.domains.Comment;
import kr.megaptera.assignment.dtos.CreateCommentResponse;
import kr.megaptera.assignment.dtos.DeleteCommentResponse;
import kr.megaptera.assignment.dtos.GetCommentListResponse;
import kr.megaptera.assignment.dtos.UpdateCommentRequest;
import kr.megaptera.assignment.dtos.UpdateCommentResponse;
import kr.megaptera.assignment.repositories.CommentRepository;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }


    public CreateCommentResponse createComment(Comment comment) {
        Comment result = commentRepository.save(comment);

        return new CreateCommentResponse(result.getId().toString(), result.getPostId().toString(),
                result.getAuthor(), result.getContent());
    }

    public List<GetCommentListResponse> getCommentList(Long postId) {
        List<Comment> comments = commentRepository.findByPostId(postId);
        List<GetCommentListResponse> result = new ArrayList<>();

        for (Comment comment : comments) {
            result.add(new GetCommentListResponse(comment.getId().toString(),
                    comment.getPostId().toString(), comment.getAuthor(), comment.getContent()));
        }

        return result;
    }

    public UpdateCommentResponse updateComment(Long id, Long postId,
            UpdateCommentRequest request) {
        Comment comment = commentRepository.findById(id);

        comment.changeContent(request.getContent());

        return new UpdateCommentResponse(comment.getId().toString(), comment.getPostId().toString(),
                comment.getAuthor(), comment.getContent());
    }

    public DeleteCommentResponse deleteComment(Long id, Long postId) {
        Comment comment = commentRepository.delete(id);

        return new DeleteCommentResponse(comment.getId().toString(), comment.getPostId().toString(),
                comment.getAuthor(), comment.getContent());
    }
}
