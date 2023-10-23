package kr.megaptera.assignment.domains.comment;

import kr.megaptera.assignment.domains.MultilineText;
import kr.megaptera.assignment.domains.post.PostId;

public class Comment {
    private CommentId id;
    private PostId postId;
    private String author;
    private MultilineText content;

    public Comment(PostId postId, String author, MultilineText content) {
        this.id = CommentId.getnerate();
        this.postId = postId;
        this.author = author;
        this.content = content;
    }

    public CommentId id() {
        return id;
    }

    public PostId postId() {
        return postId;
    }

    public String author() {
        return author;
    }

    public MultilineText content() {
        return content;
    }


    public void update(MultilineText multilineText) {
        this.content = multilineText;
    }
}
