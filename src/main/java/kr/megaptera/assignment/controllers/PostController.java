package kr.megaptera.assignment.controllers;

import kr.megaptera.assignment.application.PostService;
import kr.megaptera.assignment.domain.Post;
import kr.megaptera.assignment.dtos.PostDto;
import kr.megaptera.assignment.exceptions.PostNotFound;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
@CrossOrigin
@Slf4j
public class PostController {

    private final PostService postService;

    /**
     * 게시글 조회
     *
     * @param
     * @return
     */
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PostDto> getPostList() {
        return postService.getPostList();
    }

    /**
     * 게시글 상세 조회
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PostDto getPost(@PathVariable String id) throws PostNotFound {
        return postService.getPost(id);
    }

    /**
     * 게시글 생성
     *
     * @param postDto
     * @return
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PostDto createPost(@RequestBody PostDto postDto) {
        return postService.createPost(postDto);
    }

    /**
     * 게시글 수정
     * @param id
     * @param postDto
     * @return
     */
    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePost(@PathVariable("id") String id,
                           @RequestBody PostDto postDto) throws PostNotFound {
        postService.updatePost(id, postDto);
    }

    /**
     * 게시글 삭제
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public PostDto deletePost(@PathVariable("id") String id) throws PostNotFound {
        return postService.deletePost(id);
    }

}
