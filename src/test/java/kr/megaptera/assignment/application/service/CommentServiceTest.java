package kr.megaptera.assignment.application.service;

import kr.megaptera.assignment.application.domain.Comment;
import kr.megaptera.assignment.application.domain.CommentId;
import kr.megaptera.assignment.application.domain.Post;
import kr.megaptera.assignment.application.domain.PostId;
import kr.megaptera.assignment.dtos.CommentDeleteResponseDTO;
import kr.megaptera.assignment.dtos.CommentGetResponseDTO;
import kr.megaptera.assignment.dtos.CommentUpdateRequestDTO;
import kr.megaptera.assignment.dtos.CommentUpdateResponseDTO;
import kr.megaptera.assignment.repositories.CommentRepository;
import kr.megaptera.assignment.repositories.PostRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;


@SpringBootTest
class CommentServiceTest {
    @Autowired
    CommentService commentService;

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    PostRepository postRepository;

    @AfterEach
    void tearDown() {
        commentRepository.deleteAll();
    }

    @DisplayName("댓글 상세조회에 빈 배열을 반환한다")
    @Test
    void list_Empty() {
        // given
        String postId = "232";

        // when
        List<CommentGetResponseDTO> list = commentService.list(postId);

        // then
        Assertions.assertThat(list).isEmpty();
    }


    @DisplayName("댓글 상세조회에 성공한다")
    @Test
    void list() {
        // given
        String postId = "232";
        Comment comment = Comment.builder()
                .author("author")
                .content("content")
                .postId(PostId.of(postId))
                .build();
        Comment savedComment1 = commentRepository.save(comment);
        Comment savedComment2 = commentRepository.save(comment);
        Comment savedComment3 = commentRepository.save(comment);

        List<CommentGetResponseDTO> expected
                = Stream.of(savedComment1, savedComment2, savedComment3).map(CommentGetResponseDTO::from).toList();

        // when
        List<CommentGetResponseDTO> list = commentService.list(postId);

        // then
        Assertions.assertThat(list)
                .hasSize(3)
                .isEqualTo(expected);

    }

    @DisplayName("댓글 수정에 성공한다")
    @Test
    void update() {
        // given
        Post post = Post.builder()
                .title("title")
                .content("content")
                .author("author")
                .build();
        Post savedPost = postRepository.save(post);

        String author = "author";
        Comment comment = Comment.builder()
                .author(author)
                .content("content")
                .postId(savedPost.getId())
                .build();
        Comment savedComment1 = commentRepository.save(comment);
        comment.setPostId(post.getId());

        String changedContent = "changed";
        CommentUpdateRequestDTO requestDTO = CommentUpdateRequestDTO.builder()
                .content(changedContent)
                .build();


        // when
        CommentUpdateResponseDTO responseDTO = commentService.update(
                savedComment1.getId().toString(),
                savedComment1.getPostId().toString(),
                requestDTO);

        // then
        Assertions.assertThat(responseDTO)
                .hasFieldOrPropertyWithValue("id", savedComment1.getId().toString())
                .hasFieldOrPropertyWithValue("content", changedContent)
                .hasFieldOrPropertyWithValue("author", author);
    }

    @DisplayName("댓글 삭제에 성공한다")
    @Test
    void delete() {
        // given
        Post post = Post.builder()
                .title("title")
                .content("content")
                .author("author")
                .build();
        Post savedPost = postRepository.save(post);

        String author = "author";
        String content = "content";
        Comment comment = Comment.builder()
                .author(author)
                .content(content)
                .postId(savedPost.getId())
                .build();
        Comment savedComment = commentRepository.save(comment);
        comment.setPostId(post.getId());

        // when
        String commentId = savedComment.getId().toString();
        CommentDeleteResponseDTO responseDTO
                = commentService.delete(commentId, savedPost.getId().toString());

        // then
        Assertions.assertThat(responseDTO)
                .hasFieldOrPropertyWithValue("id", commentId)
                .hasFieldOrPropertyWithValue("author", author)
                .hasFieldOrPropertyWithValue("content", content);
        assertFalse(commentRepository.exists(CommentId.of(commentId)));

    }
}