package kr.megaptera.assignment.application;

import kr.megaptera.assignment.dtos.CommentCreateDto;
import kr.megaptera.assignment.dtos.CommentReadDto;
import kr.megaptera.assignment.dtos.CommentUpdateDto;
import kr.megaptera.assignment.exceptions.CommentNotFoundException;
import kr.megaptera.assignment.repositories.CommentRepository;
import kr.megaptera.assignment.services.CommentReadDtoFactory;
import kr.megaptera.assignment.services.NewCommentFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class CommentService {
    @Autowired
    private final CommentReadDtoFactory commentReadDtoFactory;
    @Autowired
    private final CommentRepository commentRepository;
    @Autowired
    private final NewCommentFactory newCommentFactory;

    public CommentReadDto[] findByPost(String postId) {
        var comments = commentRepository.findByPostId(postId);
        return Arrays.stream(comments)
                .map(commentReadDtoFactory::create)
                .toArray(CommentReadDto[]::new);
    }

    public CommentReadDto add(
            String postId,
            CommentCreateDto requestBody) {

        var comment = newCommentFactory.create(postId, requestBody);
        commentRepository.add(comment);

        return commentReadDtoFactory.create(comment);
    }

    public CommentReadDto update(String commentId, CommentUpdateDto reqBody) throws CommentNotFoundException {
        var comment = commentRepository.find(commentId);
        if (comment == null) {
            throw new CommentNotFoundException();
        }

        comment.setContent(reqBody.getContent());
        commentRepository.update(comment);

        return commentReadDtoFactory.create(comment);
    }

    public CommentReadDto remove(String commentId) throws CommentNotFoundException {
        var comment = commentRepository.find(commentId);
        if (comment == null) {
            throw new CommentNotFoundException();
        }

        commentRepository.remove(comment);

        return commentReadDtoFactory.create(comment);
    }
}
