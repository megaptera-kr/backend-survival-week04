package kr.megaptera.assignment.models;

import com.github.f4b6a3.tsid.TsidCreator;

public class Comment {
    private CommentId id;
    private Author author;
    private CommentContent content;

    private PostId postId;

    public CommentId id() {
        return id;
    }

    public Author author() {
        return author;
    }

    public CommentContent content() {
        return content;
    }

    public PostId postId() {
        return postId;
    }

    public Comment(CommentId commentId, PostId postId, Author author, CommentContent content) {
        this.id = commentId;
        this.postId = postId;
        this.author = author;
        this.content = content;
    }

    public Comment(PostId postId, Author author, CommentContent content) {
        this.id = CommentId.of(TsidCreator.getTsid().toString());
        this.postId = postId;
        this.author = author;
        this.content = content;
    }
}
