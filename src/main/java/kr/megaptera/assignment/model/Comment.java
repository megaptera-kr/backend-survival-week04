package kr.megaptera.assignment.model;

public class Comment {
    private CommentId id;
    private PostId postId;
    private SingleLineText author;
    private MultiLineText content;

    public Comment(CommentId id, PostId postId, SingleLineText author, MultiLineText content) {
        this.id = id;
        this.postId = postId;
        this.author = author;
        this.content = content;
    }

    public Comment(PostId postId, SingleLineText author, MultiLineText content) {
        this.id = new CommentId("99");
        this.postId = postId;
        this.author = author;
        this.content = content;
    }

    public CommentId id(){
        return id;
    }

    public PostId postid(){
        return postId;
    }

    public SingleLineText author(){
        return author;
    }

    public MultiLineText content(){
        return content;
    }
}
