package kr.megaptera.assignment.application;

import kr.megaptera.assignment.domains.MultilineText;
import kr.megaptera.assignment.domains.post.Post;
import kr.megaptera.assignment.domains.post.PostId;
import kr.megaptera.assignment.dtos.PostDto;
import kr.megaptera.assignment.repositories.PostRepository;

import java.util.List;

public class PostService {

    PostRepository postRepository;

    public PostService() {
        this.postRepository = new PostRepository();
    }

    public List<PostDto> getList() {
        List<Post> posts = postRepository.findAll();

        return posts.stream().map(post -> new PostDto(post)).toList();
    }

    public PostDto getDetail(String id) {
        Post post = postRepository.findPost(id);
        return new PostDto(post);
    }

    public PostDto create(PostDto reqBody) {
        Post post = new Post(
            reqBody.getTitle(),
            reqBody.getAuthor(),
            new MultilineText(reqBody.getContent())
        );
        PostDto postDto =  postRepository.save(post);

        return postDto;
    }

    public PostDto update(String id, PostDto reqBody) {
        Post post = postRepository.findPost(id);
        post.update(
            reqBody.getTitle(),
            new MultilineText(reqBody.getContent())
        );

        return new PostDto(post);
    }
    public PostDto delete(String id) {
        Post post = postRepository.findPost(id);
        postRepository.delete(new PostId(id));

        return new PostDto(post);
    }
}
