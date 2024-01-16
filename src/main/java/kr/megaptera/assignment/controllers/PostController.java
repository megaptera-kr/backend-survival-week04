package kr.megaptera.assignment.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kr.megaptera.assignment.application.PostService;
import kr.megaptera.assignment.dtos.PostCreateDto;
import kr.megaptera.assignment.dtos.PostDto;
import kr.megaptera.assignment.dtos.PostUpdateDto;
import kr.megaptera.assignment.exceptions.PostNotFound;

@RestController
@RequestMapping("/posts")
@CrossOrigin
public class PostController {
	private final PostService postService;

	public PostController() {
		this.postService = new PostService();
	}

	@GetMapping
	public List<PostDto> list() {
		List<PostDto> postDtos = postService.getPostDtos();
		return postDtos;
	}

	@GetMapping("/{id}")
	public PostDto detail(@PathVariable String id) {
		PostDto postDto = postService.getPostDto(id);

		return postDto;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public PostDto create(@RequestBody PostCreateDto postCreateDto) {
		PostDto created = postService.createPost(postCreateDto);
		return created;
	}

	@PatchMapping("/{id}")
	public PostDto update(@PathVariable String id,
		@RequestBody PostUpdateDto postUpdateDto) {
		PostDto updated = postService.updatePost(id, postUpdateDto);
		return updated;
	}

	@DeleteMapping("/{id}")
	public PostDto delete(@PathVariable String id) {
		PostDto postDto = postService.deletePost(id);
		return postDto;
	}

	@ExceptionHandler(PostNotFound.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String postNotFound() {
		return "게시물을 찾을 수 없습니다.";
	}
}
