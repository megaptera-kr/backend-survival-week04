package kr.megaptera.assignment.models;

public class CommentContent {
    private MultilineContent content;

    public CommentContent(String content) {
        this.content = new MultilineContent(content);
    }

    public CommentContent(MultilineContent content) {
        this.content = content;
    }

    public static CommentContent of(String content){
        return new CommentContent(MultilineContent.of(content));
    }
}
