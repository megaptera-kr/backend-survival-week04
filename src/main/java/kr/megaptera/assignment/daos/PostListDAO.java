package kr.megaptera.assignment.daos;

import kr.megaptera.assignment.dtos.PostDto;
import kr.megaptera.assignment.dtos.request.RqCreatePostDto;
import kr.megaptera.assignment.exceptions.NotFoundException;
import kr.megaptera.assignment.models.Author;
import kr.megaptera.assignment.models.Content;
import kr.megaptera.assignment.models.Post;
import kr.megaptera.assignment.models.PostId;
import kr.megaptera.assignment.models.Title;
import kr.megaptera.assignment.repositories.PostRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PostListDAO implements PostDAO {
    private final PostRepository postRepository;

    public PostListDAO() {
        this.postRepository = new PostRepository();
    }

    @Override
    public List<PostDto> getPostList() {
        List<Post> postList = postRepository.findAll();

        return postList.stream()
                .map(PostDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public PostDto getPostById(int postId) {
        Optional<Post> post = postRepository.findById(PostId.of(postId));
        if (post.isEmpty()) {
            throw new NotFoundException();
        }
        return new PostDto(post.get());
    }

    @Override
    public PostDto createPost(RqCreatePostDto dto) {
        Post post = new Post(Title.of(dto.getTitle()),
                Author.of(dto.getAuthor()),
                Content.of(dto.getContent()));
        Post savePost = postRepository.savePost(post);
        return new PostDto(savePost);
    }
}
