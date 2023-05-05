package kr.megaptera.assignment.models;

public class Comment {

    private CommentId id;

    private PostId postId;
    private String author;
    private CommentText content;

    public Comment(CommentId id, PostId postId, String author, CommentText content) {
        this.id = id;
        this.postId = postId;
        this.author = author;
        this.content = content;
    }

    public Comment(PostId postId, String author, CommentText content) {
        this.id = CommentId.generate();
        this.postId = postId;
        this.author = author;
        this.content = content;
    }

    public CommentId id (){
        return id;
    }

    public CommentText content(){
        return content;
    }

    public String author() {
        return author;
    }

    public PostId postId() {
        return postId;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", postId=" + postId +
                ", author='" + author + '\'' +
                ", content=" + content +
                '}';
    }

    public void update(CommentText updateContent) {
        this.content = updateContent;
    }
}
