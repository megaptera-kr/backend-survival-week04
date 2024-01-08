package kr.megaptera.assignment.controllers;

import kr.megaptera.assignment.application.CommentService;
import kr.megaptera.assignment.dtos.CommentDto;
import kr.megaptera.assignment.exceptions.CommentNotFound;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
@CrossOrigin
public class CommentController {

    private final CommentService commentService;

    /**
     * 댓글 조회
     * @param postId
     * @return
     */
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CommentDto> getCommentList(@RequestParam String postId) {
        return commentService.getCommentList(postId);
    }

    /**
     * 댓글 생성
     * @param postId
     * @param commentDto
     * @return
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CommentDto createComment(@RequestParam String postId, @RequestBody CommentDto commentDto) {
        return commentService.createComment(postId, commentDto);
    }

    /**
     * 댓글 수정
     * @param id
     * @param postId
     * @param commentDto
     */
    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateComment(@PathVariable("id") String id,
                              @RequestParam String postId,
                              @RequestBody CommentDto commentDto) throws CommentNotFound {
        commentService.updateComment(id, postId, commentDto);
    }

    /**
     * 댓글 삭제
     * @param id
     * @param postId
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public CommentDto deleteComment(@PathVariable("id") String id,
                              @RequestParam String postId) throws CommentNotFound {
        return commentService.deleteComment(id, postId);
    }

}

