package kr.megaptera.assignment.models;

public class Comment {
    private CommentId commentId;
    private PostId postId;
    private Author author;
    private MultilineText content;

    public Comment(CommentId commentId, PostId postId, Author author, MultilineText content) {
        this.commentId = commentId;
        this.postId = postId;
        this.author = author;
        this.content = content;
    }

    public Comment(PostId postId, Author author, MultilineText content) {
        this.commentId = CommentId.generate();
        this.postId = postId;
        this.author = author;
        this.content = content;
    }

    public CommentId commentId() {
        return commentId;
    }

    public PostId postId() {
        return postId;
    }

    public Author author() {
        return author;
    }

    public MultilineText content() {
        return content;
    }

    public void update(String content) {
        this.content = MultilineText.of(content);
    }
}
