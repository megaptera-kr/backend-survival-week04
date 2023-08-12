package kr.megaptera.assignment.application;

import kr.megaptera.assignment.dtos.CommentCreateRequestDTO;
import kr.megaptera.assignment.dtos.CommentCreateResponseDTO;
import kr.megaptera.assignment.dtos.CommentDeleteResponseDTO;
import kr.megaptera.assignment.dtos.CommentGetResponseDTO;
import kr.megaptera.assignment.dtos.CommentUpdateRequestDTO;
import kr.megaptera.assignment.dtos.CommentUpdateResponseDTO;
import kr.megaptera.assignment.exceptions.ParsingException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CommentService {
    public List<CommentGetResponseDTO> list(String postId) {
        Long parsedPostId = parsingLong(postId);
        return null;
    }

    public CommentCreateResponseDTO create(String postId,
                                           CommentCreateRequestDTO requestDTO) {
        Long parsedPostId = parsingLong(postId);
        return null;
    }

    public CommentUpdateResponseDTO update(String commentId,
                                           String postId,
                                           CommentUpdateRequestDTO requestDTO) {
        Long parsedCommentId = parsingLong(commentId);
        Long parsedPostId = parsingLong(postId);

        return null;
    }

    public CommentDeleteResponseDTO delete(String commentId,
                                           String postId) {

        return null;
    }

    private Long parsingLong(String id) {
        Long postId;
        try {
            postId = Long.parseLong(id);
        } catch (NumberFormatException e) {
            throw new ParsingException();
        }

        return postId;
    }
}
