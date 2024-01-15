package kr.megaptera.assignment.models.comment;

public class CommentContent {

    private String value;

    private CommentContent(String value) {
        this.value = value;
    }

    public static CommentContent of(String content) {
        return new CommentContent(content);
    }

    @Override
    public String toString() {
        return value;
    }
}
