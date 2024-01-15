package kr.megaptera.assignment.models.post;

public class PostAuthor {

    private final String value;

    private PostAuthor(String value) {
        this.value = value;
    }

    public static PostAuthor of(String value) {
        return new PostAuthor(value);
    }

    @Override
    public String toString() {
        return value;
    }
}
