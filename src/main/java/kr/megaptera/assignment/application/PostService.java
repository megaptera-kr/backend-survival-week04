package kr.megaptera.assignment.application;

import kr.megaptera.assignment.dtos.PostDto;
import kr.megaptera.assignment.models.post.Author;
import kr.megaptera.assignment.models.post.Post;
import kr.megaptera.assignment.models.post.PostContent;
import kr.megaptera.assignment.models.post.PostId;
import kr.megaptera.assignment.models.post.PostTitle;
import kr.megaptera.assignment.repositories.PostRepository;

import java.util.List;

public class PostService {

    private final PostRepository postRepository;

    public PostService() {
        this.postRepository = new PostRepository();
    }

    public List<PostDto> list() {
        // get all postDtos from postRepository
        List<Post> posts = postRepository.findAll();
        // convert posts to postDto
        return posts.stream()
                .map(PostDto::new)
                .toList();
    }

    public PostDto detail(String id) {
        // get post from postRepository
        Post post = postRepository.findById(PostId.of(id));
        // convert post to postDto
        return new PostDto(post);
    }

    public PostDto create(PostDto postDto) {
        // create post
        Post post = new Post(
                PostTitle.of(postDto.getTitle()),
                Author.of(postDto.getAuthor()),
                PostContent.of(postDto.getContent())
        );

        // save post to postRepository
        postRepository.save(post);
        // convert post to postDto
        return new PostDto(post);
    }

    public PostDto update(String id, PostDto postDto) {
        // update post
        Post post = this.postRepository.update(
                PostId.of(id),
                PostTitle.of(postDto.getTitle()),
                PostContent.of(postDto.getContent())
        );
        // convert post to postDto
        return new PostDto(post);
    }

    public PostDto delete(String id) {
        // delete post from postRepository
        Post post = postRepository.delete(PostId.of(id));

        // convert post to postDto
        return new PostDto(post);
    }
}
