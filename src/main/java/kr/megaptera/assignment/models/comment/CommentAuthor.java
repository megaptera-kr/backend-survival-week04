package kr.megaptera.assignment.models.comment;

public class CommentAuthor {

    private final String value;

    private CommentAuthor(String value) {
        this.value = value;
    }

    public static CommentAuthor of(String author) {
        return new CommentAuthor(author);
    }

    @Override
    public String toString() {
        return value;
    }
}
