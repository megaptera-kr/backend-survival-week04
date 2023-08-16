package kr.megaptera.assignment.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import kr.megaptera.assignment.application.service.CommentService;
import kr.megaptera.assignment.dtos.CommentCreateRequestDTO;
import kr.megaptera.assignment.dtos.CommentCreateResponseDTO;
import kr.megaptera.assignment.dtos.CommentDeleteResponseDTO;
import kr.megaptera.assignment.dtos.CommentGetResponseDTO;
import kr.megaptera.assignment.dtos.CommentUpdateRequestDTO;
import kr.megaptera.assignment.dtos.CommentUpdateResponseDTO;
import kr.megaptera.assignment.exceptions.ErrorCode;
import kr.megaptera.assignment.exceptions.ErrorResponse;
import kr.megaptera.assignment.exceptions.ParsingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = {CommentController.class})
class CommentControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    CommentController commentController;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    CommentService commentService;

    @DisplayName("댓글 조회에 성공한다")
    @Test
    void list() throws
                Exception {
        // Given
        CommentGetResponseDTO responseDTO1
                = CommentGetResponseDTO.builder()
                                       .build();

        CommentGetResponseDTO responseDTO2
                = CommentGetResponseDTO.builder()
                                       .build();

        List<CommentGetResponseDTO> dtoList = List.of(responseDTO1,
                                                      responseDTO2);
        String responseBody = objectMapper.writeValueAsString(dtoList);
        String postId = "1";
        when(commentService.list(postId)).thenReturn(dtoList);

        // When // Then
        mockMvc.perform(
                       get("/comments")
                               .queryParam("postId",
                                           postId)
                       )
               .andDo(print())
               .andExpect(status().isOk())
               .andExpect(content().json(responseBody));
    }

    @DisplayName("댓글 조회에 post id parsing 에 실패한다")
    @Test
    void list_Parsing_Exception() throws
                                  Exception {
        // Given
        String postId = "1";
        ErrorResponse errorResponse = ErrorResponse.of(ErrorCode.INVALID_INPUT_VALUE);
        String responseBody = objectMapper.writeValueAsString(errorResponse);

        when(commentService.list(postId)).thenThrow(ParsingException.class);

        // When // Then
        mockMvc.perform(
                       get("/comments")
                               .queryParam("postId",
                                           postId)
                       )
               .andDo(print())
               .andExpect(status().is(ErrorCode.INVALID_INPUT_VALUE.getStatus().value()))
               .andExpect(content().json(responseBody));
    }

    @DisplayName("댓글 작성에 성공한다")
    @Test
    void create() throws
                  Exception {
        // Given
        String postId = "1";
        CommentCreateRequestDTO requestDTO = CommentCreateRequestDTO.builder()
                                                                    .build();
        String requestBody = objectMapper.writeValueAsString(requestDTO);

        CommentCreateResponseDTO responseDTO = CommentCreateResponseDTO.builder()
                                                                       .build();
        String responseBody = objectMapper.writeValueAsString(responseDTO);
        when(commentService.create(postId,
                                   requestDTO)).thenReturn(responseDTO);

        // When // Then
        mockMvc.perform(
                       post("/comments")
                               .queryParam("postId",
                                           postId)
                               .contentType(MediaType.APPLICATION_JSON)
                               .content(requestBody)
                       )
               .andDo(print())
               .andExpect(status().isCreated())
               .andExpect(content().json(responseBody));
    }

    @DisplayName("댓글 작성시 post id parsing 에 실패한다")
    @Test
    void create_Parsing_Exception() throws
                                    Exception {
        // Given
        String postId = "1";
        CommentCreateRequestDTO requestDTO = CommentCreateRequestDTO.builder()
                                                                    .build();
        String requestBody = objectMapper.writeValueAsString(requestDTO);

        ErrorResponse errorResponse = ErrorResponse.of(ErrorCode.INVALID_INPUT_VALUE);
        String responseBody = objectMapper.writeValueAsString(errorResponse);

        when(commentService.create(postId,
                                   requestDTO)).thenThrow(ParsingException.class);

        // When // Then
        mockMvc.perform(
                       post("/comments")
                               .queryParam("postId",
                                           postId)
                               .contentType(MediaType.APPLICATION_JSON)
                               .content(requestBody)
                       )
               .andDo(print())
               .andExpect(status().is(ErrorCode.INVALID_INPUT_VALUE.getStatus().value()))
               .andExpect(content().json(responseBody));
    }

    @DisplayName("댓글 수정에 성공한다")
    @Test
    void update() throws
                  Exception {
        // Given
        String commentId = "2";
        String postId = "1";
        CommentUpdateRequestDTO requestDTO = CommentUpdateRequestDTO.builder()
                                                                    .build();

        String requestBody = objectMapper.writeValueAsString(requestDTO);

        CommentUpdateResponseDTO responseDTO = CommentUpdateResponseDTO.builder()
                                                                       .build();

        String responseBody = objectMapper.writeValueAsString(responseDTO);

        when(commentService.update(commentId,
                                   postId,
                                   requestDTO)).thenReturn(responseDTO);

        // When // Then
        mockMvc.perform(
                       patch("/comments/{id}",
                             commentId)
                               .queryParam("postId",
                                           postId)
                               .contentType(MediaType.APPLICATION_JSON)
                               .content(requestBody)
                       )
               .andDo(print())
               .andExpect(status().isOk())
               .andExpect(content().json(responseBody));

    }

    @DisplayName("댓글수정시 postId 값 파싱에 실패한다")
    @Test
    void update_postId_Parsing_Exception() throws
                                           Exception {
        // Given
        String commentId = "2";
        String postId = "1";
        CommentUpdateRequestDTO requestDTO = CommentUpdateRequestDTO.builder()
                                                                    .build();
        String requestBody = objectMapper.writeValueAsString(requestDTO);

        ErrorResponse errorResponse = ErrorResponse.of(ErrorCode.INVALID_INPUT_VALUE);
        String responseBody = objectMapper.writeValueAsString(errorResponse);

        when(commentService.update(commentId,
                                   postId,
                                   requestDTO)).thenThrow(ParsingException.class);
        // When // Then
        mockMvc.perform(
                       patch("/comments/{id}",
                             commentId)
                               .queryParam("postId",
                                           postId)
                               .contentType(MediaType.APPLICATION_JSON)
                               .content(requestBody)
                       )
               .andDo(print())
               .andExpect(status().is(ErrorCode.INVALID_INPUT_VALUE.getStatus().value()))
               .andExpect(content().json(responseBody));
    }

    @DisplayName("댓글 삭제에 성공한다")
    @Test
    void deletePost() throws
                      Exception {
        // Given
        String commentId = "2";
        String postId = "1";

        CommentDeleteResponseDTO responseDTO = CommentDeleteResponseDTO.builder().build();
        String responseBody = objectMapper.writeValueAsString(responseDTO);

        when(commentService.delete(commentId,
                                   postId)).thenReturn(responseDTO);

        // When // Then
        mockMvc.perform(
                       delete("/comments/{id}",
                              commentId)
                               .queryParam("postId",
                                           postId)
                       )
               .andDo(print())
               .andExpect(status().isOk())
               .andExpect(content().json(responseBody));
    }

    @DisplayName("댓글 삭제에 postId 혹은 commentId 파싱에 실패한다")
    @Test
    void delete_Parsing_Exception() throws
                                    Exception {
        // Given
        String commentId = "2";
        String postId = "1";

        ErrorResponse errorResponse = ErrorResponse.of(ErrorCode.INVALID_INPUT_VALUE);
        String responseBody = objectMapper.writeValueAsString(errorResponse);

        when(commentService.delete(commentId,
                                   postId)).thenThrow(ParsingException.class);
        // When // Then
        mockMvc.perform(
                       delete("/comments/{id}",
                             commentId)
                               .queryParam("postId",
                                           postId)
                       )
               .andDo(print())
               .andExpect(status().is(ErrorCode.INVALID_INPUT_VALUE.getStatus().value()))
               .andExpect(content().json(responseBody));
    }
}