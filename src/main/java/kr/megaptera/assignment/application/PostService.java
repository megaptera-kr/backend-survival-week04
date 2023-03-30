package kr.megaptera.assignment.application;

import jakarta.annotation.PostConstruct;
import kr.megaptera.assignment.dtos.PostCreateDto;
import kr.megaptera.assignment.dtos.PostReadDto;
import kr.megaptera.assignment.dtos.PostUpdateDto;
import kr.megaptera.assignment.exceptions.PostNotFoundException;
import kr.megaptera.assignment.repositories.PostRepository;
import kr.megaptera.assignment.services.NewPostFactory;
import kr.megaptera.assignment.services.PostDtoFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final PostDtoFactory postDtoFactory;
    private final NewPostFactory newPostFactory;

    public PostReadDto[] findAll() {
        var posts = postRepository.findAll();
        return Arrays.stream(posts)
                .map(postDtoFactory::create)
                .toArray(PostReadDto[]::new);
    }

    public PostReadDto find(String id) throws PostNotFoundException {
        var post = postRepository.find(id);
        if (post == null) {
            throw new PostNotFoundException();
        }

        return postDtoFactory.create(post);
    }

    public PostReadDto add(PostCreateDto source) {
        var post = newPostFactory.create(source);
        postRepository.add(post);

        return postDtoFactory.create(post);
    }

    public PostReadDto update(String id, PostUpdateDto source)
            throws PostNotFoundException {
        var post = postRepository.find(id);
        if (post == null) {
            throw new PostNotFoundException();
        }

        post.setContent(source.getContent());
        postRepository.update(id, post);

        return postDtoFactory.create(post);
    }

    public PostReadDto remove(String id) throws PostNotFoundException {
        var post = postRepository.find(id);
        if (post == null) {
            throw new PostNotFoundException();
        }

        postRepository.remove(id);

        // TODO : (dh) how can i remove comments?
        return postDtoFactory.create(post);
    }
}
