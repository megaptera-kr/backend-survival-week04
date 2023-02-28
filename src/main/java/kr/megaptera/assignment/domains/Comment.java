package kr.megaptera.assignment.domains;

import kr.megaptera.assignment.dtos.CommentCreateDto;
import kr.megaptera.assignment.dtos.CommentUpdateDto;

public class Comment {

    private PostId postId;
    private CommentId commentId;
    private String author;
    private String content;

    public Comment(PostId postId, CommentId commentId, String author, String content) {
        this.postId = postId;
        this.commentId = commentId;
        this.author = author;
        this.content = content;
    }

    public Comment(String postId, CommentCreateDto commentCreateDto) {
        this(PostId.of(postId), CommentId.generateId(), commentCreateDto.getAuthor(), commentCreateDto.getContent());
    }

    public boolean isExists(PostId postId) {
        return this.postId.equals(postId);
    }

    public boolean isExists(PostId postId, CommentId commentId) {
        return this.postId.equals(postId) && this.commentId.equals(commentId);
    }

    public PostId postId() {
        return postId;
    }

    public CommentId commentId() {
        return commentId;
    }

    public String author() {
        return author;
    }

    public String content() {
        return content;
    }

    public void update(CommentUpdateDto commentUpdateDto) {
        this.content = commentUpdateDto.getContent();
    }
}
