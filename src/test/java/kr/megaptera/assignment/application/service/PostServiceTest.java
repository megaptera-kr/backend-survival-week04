package kr.megaptera.assignment.application.service;

import kr.megaptera.assignment.application.domain.Post;
import kr.megaptera.assignment.dtos.PostDeleteResponseDTO;
import kr.megaptera.assignment.dtos.PostGetResponseDTO;
import kr.megaptera.assignment.dtos.PostUpdateRequestDTO;
import kr.megaptera.assignment.dtos.PostUpdateResponseDTO;
import kr.megaptera.assignment.repositories.PostRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Stream;

@SpringBootTest
class PostServiceTest {
    @Autowired
    PostService postService;

    @Autowired
    PostRepository postRepository;

    @AfterEach
    void tearDown() {
        postRepository.deleteAll();
    }

    @DisplayName("게시글 목록조회에 성공한다")
    @Test
    void list() {
        // given
        Post post = Post.builder()
                .title("title")
                .content("content")
                .author("author")
                .build();
        Post savedPost1 = postRepository.save(post);
        Post savedPost2 = postRepository.save(post);
        List<PostGetResponseDTO> list
                = Stream.of(savedPost1, savedPost2).map(PostGetResponseDTO::from).toList();

        // when
        List<PostGetResponseDTO> dtoList = postService.list();

        // then
        Assertions.assertThat(dtoList).isEqualTo(list);

    }

    @DisplayName("게시글 상세조회에 성공한다")
    @Test
    void get() {
        // given
        String title = "title";
        String content = "content";
        String author = "author";
        Post post = Post.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
        Post savedPost = postRepository.save(post);

        // when
        PostGetResponseDTO responseDTO = postService.get(String.valueOf(savedPost.getId()));

        // then
        Assertions.assertThat(responseDTO)
                .hasFieldOrPropertyWithValue("id", savedPost.getId().toString())
                .hasFieldOrPropertyWithValue("title", title)
                .hasFieldOrPropertyWithValue("content", content)
                .hasFieldOrPropertyWithValue("author", author);

    }

    @DisplayName("게시글 업데이트에 성공한다")
    @Test
    void update() {
        // given
        String author = "author";
        Post post = Post.builder()
                .title("title")
                .content("content")
                .author(author)
                .build();

        String updatedTitle = "eltit";
        String updatedContent = "tnetcont";
        PostUpdateRequestDTO requestDTO = PostUpdateRequestDTO.builder()
                .title(updatedTitle)
                .content(updatedContent)
                .build();

        Post savedPost = postRepository.save(post);

        // when
        PostUpdateResponseDTO responseDTO = postService.update(
                String.valueOf(savedPost.getId()), requestDTO);

        // then
        Assertions.assertThat(responseDTO)
                .hasFieldOrPropertyWithValue("id", savedPost.getId().toString())
                .hasFieldOrPropertyWithValue("title", updatedTitle)
                .hasFieldOrPropertyWithValue("content", updatedContent)
                .hasFieldOrPropertyWithValue("author", author);

    }

    @DisplayName("게시글 삭제에 성공한다")
    @Test
    void delete() {
        // given
        String title = "title";
        String content = "content";
        String author = "author";
        Post post = Post.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
        Post savedPost = postRepository.save(post);

        // when
        PostDeleteResponseDTO responseDTO = postService.delete(String.valueOf(savedPost.getId()));

        // then
        Assertions.assertThat(responseDTO)
                .hasFieldOrPropertyWithValue("id", savedPost.getId().toString())
                .hasFieldOrPropertyWithValue("title", title)
                .hasFieldOrPropertyWithValue("content", content)
                .hasFieldOrPropertyWithValue("author", author);

    }
}