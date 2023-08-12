package kr.megaptera.assignment.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import kr.megaptera.assignment.application.PostService;
import kr.megaptera.assignment.dtos.PostCreateRequestDTO;
import kr.megaptera.assignment.dtos.PostCreateResponseDTO;
import kr.megaptera.assignment.dtos.PostDeleteResponseDTO;
import kr.megaptera.assignment.dtos.PostGetResponseDTO;
import kr.megaptera.assignment.dtos.PostUpdateRequestDTO;
import kr.megaptera.assignment.dtos.PostUpdateResponseDTO;
import kr.megaptera.assignment.exceptions.ErrorCode;
import kr.megaptera.assignment.exceptions.ErrorResponse;
import kr.megaptera.assignment.exceptions.PostIdParsingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest()
class PostControllerTest {
    @Autowired
    PostController postController;

    @Autowired
    MockMvc mockMvc;

    @MockBean
    PostService postService;

    @Autowired
    ObjectMapper objectMapper;

    @DisplayName("게시글 조회에 성공한다")
    @Test
    void list() throws Exception {
        // Given
        PostGetResponseDTO responseDTO1 = PostGetResponseDTO.builder()
                .id("id1")
                .title("title1")
                .content("content1")
                .author("author1")
                .build();
        PostGetResponseDTO responseDTO2 = PostGetResponseDTO.builder()
                .id("id2")
                .title("title2")
                .content("content2")
                .author("author2")
                .build();

        List<PostGetResponseDTO> dtoList = List.of(responseDTO1, responseDTO2);
        String responseBody = objectMapper.writeValueAsString(dtoList);
        when(postService.list()).thenReturn(
                dtoList);

        // When // Then
        mockMvc.perform(get("/posts"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(responseBody));
    }

    @DisplayName("게시글 상세조회에 성공한다")
    @Test
    void getPost() throws Exception {
        // Given
        PostGetResponseDTO responseDTO1 = PostGetResponseDTO.builder()
                .id("id1")
                .title("title1")
                .content("content1")
                .author("author1")
                .build();

        String pathVariable = "1";
        when(postService.get(pathVariable)).thenReturn(responseDTO1);
        String responseBody = objectMapper.writeValueAsString(responseDTO1);

        // When // Then
        mockMvc.perform(get("/posts/{id}", pathVariable))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(responseBody));
    }

    @DisplayName("게시글 상세조회에 pathVariable 을 Long 으로 파싱할 수 없어 실패한다")
    @Test
    void getPost_Parsing_Exception() throws Exception {
        // Given
        String pathVariable = "e";
        when(postService.get(pathVariable)).thenThrow(PostIdParsingException.class);

        ErrorResponse errorResponse = ErrorResponse.of(ErrorCode.INVALID_INPUT_VALUE);
        String responseBody = objectMapper.writeValueAsString(errorResponse);

        // When // Then
        mockMvc.perform(get("/posts/{id}", pathVariable))
                .andDo(print())
                .andExpect(status().is(ErrorCode.INVALID_INPUT_VALUE.getStatus().value()))
                .andExpect(content().json(responseBody));
    }

    @DisplayName("게시글 작성에 성공한다")
    @Test
    void create() throws Exception {
        // Given
        PostCreateRequestDTO requestDTO = PostCreateRequestDTO.builder()
                .title("title1")
                .content("content1")
                .author("author1")
                .build();
        String requestBody = objectMapper.writeValueAsString(requestDTO);

        PostCreateResponseDTO responseDTO = PostCreateResponseDTO.builder()
                .id("id")
                .title("title")
                .content("content")
                .author("author")
                .build();
        String responseBody = objectMapper.writeValueAsString(responseDTO);

        when(postService.create(requestDTO)).thenReturn(responseDTO);

        // When // Then
        mockMvc.perform(
                        post("/posts")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(requestBody))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(responseBody));
    }

    @DisplayName("게시글 수정에 성공한다")
    @Test
    void test() throws Exception {
        // Given
        String pathVariable = "1";

        PostUpdateRequestDTO requestDTO = PostUpdateRequestDTO.builder()
                .title("title")
                .content("content")
                .build();
        String requestBody = objectMapper.writeValueAsString(requestDTO);

        PostUpdateResponseDTO responseDTO = PostUpdateResponseDTO.builder()
                .id("id")
                .title("title")
                .content("content")
                .author("author")
                .build();
        String responseBody = objectMapper.writeValueAsString(responseDTO);

        when(postService.update(pathVariable, requestDTO)).thenReturn(responseDTO);

        // When // Then
        mockMvc.perform(
                        patch("/posts/{id}", pathVariable)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(requestBody)
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(responseBody));
    }

    @DisplayName("게시글 수정시 Long 으로 파싱할 수 없는 값을 주어 예외를 반환한다")
    @Test
    void update_Parsing_Exception() throws Exception {
        // Given
        String pathVariable = "1";
        PostUpdateRequestDTO requestDTO = PostUpdateRequestDTO.builder()
                .title("title")
                .content("content")
                .build();
        String requestBody = objectMapper.writeValueAsString(requestDTO);

        ErrorResponse errorResponse = ErrorResponse.of(ErrorCode.INVALID_INPUT_VALUE);
        String responseBody = objectMapper.writeValueAsString(errorResponse);

        when(postService.update(pathVariable, requestDTO)).thenThrow(PostIdParsingException.class);

        // When // Then
        mockMvc.perform(
                        patch("/posts/{id}", pathVariable)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(requestBody)
                )
                .andDo(print())
                .andExpect(status().is(ErrorCode.INVALID_INPUT_VALUE.getStatus().value()))
                .andExpect(content().json(responseBody));
    }

    @DisplayName("게시글 삭제에 성공한다")
    @Test
    void deletePost() throws Exception {
        // Given
        String pathVariable = "1";

        PostDeleteResponseDTO responseDTO = PostDeleteResponseDTO.builder()
                .id("id")
                .title("title")
                .content("content")
                .author("author")
                .build();
        String responseBody = objectMapper.writeValueAsString(responseDTO);

        when(postService.delete(pathVariable)).thenReturn(responseDTO);

        // When // Then
        mockMvc.perform(
                        delete("/posts/{id}", pathVariable)
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(responseBody));
    }
}