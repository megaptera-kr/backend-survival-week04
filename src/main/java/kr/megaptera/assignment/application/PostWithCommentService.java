package kr.megaptera.assignment.application;

import kr.megaptera.assignment.dtos.CommentCreateDto;
import kr.megaptera.assignment.dtos.PostCreateDto;
import kr.megaptera.assignment.repositories.CommentRepository;
import kr.megaptera.assignment.repositories.PostRepository;
import kr.megaptera.assignment.services.NewCommentFactory;
import kr.megaptera.assignment.services.NewPostFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class PostWithCommentService {
    @Autowired
    private final NewPostFactory newPostFactory;
    @Autowired
    private final NewCommentFactory newCommentFactory;
    @Autowired
    private final PostRepository postRepository;
    @Autowired
    private final CommentRepository commentRepository;

    public void init() {
        var post1 = newPostFactory.create(
                new PostCreateDto(
                        "post 1 title",
                        "superuser",
                        "default content"));

        var post2 = newPostFactory.create(
                new PostCreateDto(
                        "post 2 title",
                        "superuser",
                        "default content"));

        var comment1 = newCommentFactory.create(
                post1.getId(),
                new CommentCreateDto(
                        "commentUser1",
                        "default comment"));

        var comment2 = newCommentFactory.create(
                post1.getId(),
                new CommentCreateDto(
                        "commentUser2",
                        "default comment"));

        postRepository.add(post1);
        postRepository.add(post2);

        commentRepository.add(comment1);
        commentRepository.add(comment2);
    }
}
