package kr.megaptera.assignment.application;

import com.github.f4b6a3.tsid.TsidCreator;
import kr.megaptera.assignment.dto.PostDto;
import kr.megaptera.assignment.models.Post;
import kr.megaptera.assignment.models.PostId;
import kr.megaptera.assignment.models.PostText;
import kr.megaptera.assignment.models.PostTitle;
import kr.megaptera.assignment.repositories.PostRepository;

import java.util.List;
import java.util.UUID;

public class PostService {

    private final PostRepository postRepository;

    public PostService() {
        postRepository = new PostRepository();
    }

    public List<PostDto> getPostList() {
        List<Post> posts = postRepository.getAll();
        return posts.stream().map(post -> new PostDto(post)).toList();
    }

    public PostDto getPost(String id) {
        Post post = postRepository.findPost(PostId.of(id));
        return new PostDto(post);
    }

    public PostDto createPost(PostDto postDto) {
        Post post = new Post(PostTitle.of(postDto.getTitle()), postDto.getAuthor(), PostText.of(postDto.getContent()));
        //System.out.println("service : createPost" + post.id() + post.author() + post.title() + post.content());
        postRepository.save(post);
        return new PostDto(post);
    }

    public PostDto updatePost(String id, PostDto postDto) {
        Post post = postRepository.findPost(PostId.of(id));
        post.update(PostTitle.of(postDto.getTitle()), PostText.of(postDto.getContent()));

        return new PostDto(post);
    }

    public PostDto removePost(String id) {
        Post post = postRepository.removePost(PostId.of(id));

        return new PostDto(post);
    }
}
