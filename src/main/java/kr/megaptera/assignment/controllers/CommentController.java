package kr.megaptera.assignment.controllers;

import kr.megaptera.assignment.application.CommentService;
import kr.megaptera.assignment.dtos.CommentCreateRequestDTO;
import kr.megaptera.assignment.dtos.CommentCreateResponseDTO;
import kr.megaptera.assignment.dtos.CommentDeleteResponseDTO;
import kr.megaptera.assignment.dtos.CommentGetResponseDTO;
import kr.megaptera.assignment.dtos.CommentUpdateRequestDTO;
import kr.megaptera.assignment.dtos.CommentUpdateResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    // 댓글조회 - GET /comments?postId={postId}
    @GetMapping
    public ResponseEntity<List<CommentGetResponseDTO>> list(@RequestParam String postId) {
        List<CommentGetResponseDTO> dtoList = commentService.list(postId);
        return new ResponseEntity<>(dtoList,
                                    HttpStatus.OK);
    }

    // 댓글작성 - POST /comments?postId={postId}
    @PostMapping
    public ResponseEntity<CommentCreateResponseDTO> create(@RequestParam String postId,
                                                           @RequestBody CommentCreateRequestDTO requestDTO) {
        CommentCreateResponseDTO responseDTO = commentService.create(postId,
                                                                     requestDTO);
        return new ResponseEntity<>(responseDTO,
                                    HttpStatus.CREATED);
    }

    // 댓글수정 - PATCH /comments/{id}?postId={postId}
    @PatchMapping("/{id}")
    public ResponseEntity<CommentUpdateResponseDTO> update(@PathVariable("id") String commentId,
                                                           @RequestParam String postId,
                                                           @RequestBody CommentUpdateRequestDTO requestDTO) {
        CommentUpdateResponseDTO responseDTO = commentService.update(commentId,
                                                                     postId,
                                                                     requestDTO);
        return new ResponseEntity<>(responseDTO,
                                    HttpStatus.OK);
    }

    // 댓글삭제 - DELETE /comments/{id}?postId={postId}
    @DeleteMapping("/{id}")
    public ResponseEntity<CommentDeleteResponseDTO> delete(@PathVariable("id") String commentId,
                                                           @RequestParam String postId) {
        CommentDeleteResponseDTO responseDTO = commentService.delete(commentId,
                                                                     postId);
        return new ResponseEntity<>(responseDTO,
                                    HttpStatus.OK);
    }
}

