package kr.megaptera.assignment.models;

import kr.megaptera.assignment.models.dtos.CommentCreateDto;
import kr.megaptera.assignment.models.dtos.CommentUpdateDto;

public class Comment {

    private CommentId id;

    private PostId postId;

    private CommentAuthor author;

    private MultilineText content;

    public Comment(PostId postId, CommentCreateDto commentCreateDto) {
        this.id = new CommentId();
        this.postId = postId;
        this.author = CommentAuthor.of(commentCreateDto.getAuthor());
        this.content = MultilineText.of(commentCreateDto.getContent());
    }

    public void updateComment(CommentUpdateDto commentUpdateDto) {
        this.content = MultilineText.of(commentUpdateDto.getContent());
    }

    public CommentId id() {
        return this.id;
    }

    public PostId postId() {
        return this.postId;
    }

    public CommentAuthor author() {
        return this.author;
    }

    public MultilineText content() {
        return this.content;
    }
}
