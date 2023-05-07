package kr.megaptera.assignment.controllerDtos;

import kr.megaptera.assignment.models.Comment;

public class CommentDto {
    private String id;
    private String postId;
    private String author;
    private String content;

    public CommentDto() {
    }

    public CommentDto(String id, String postId, String author, String content) {
        this.id = id;
        this.postId = postId;
        this.author = author;
        this.content = content;
    }

    public CommentDto(Comment comment) {
        this(comment.id().toString(), comment.postId().toString(), comment.author(), comment.content().toString());
    }

    public String getId() {
        return id;
    }

    public String getPostId() {
        return postId;
    }

    public String getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "CommentDto{" +
                "id='" + id + '\'' +
                ", postId='" + postId + '\'' +
                ", author='" + author + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
