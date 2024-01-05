package kr.megaptera.assignment.models.Post;

public class Author {

    private final String value;

    private Author(String value) {
        this.value = value;
    }

    public static Author of(String value) {
        return new Author(value);
    }

    @Override
    public String toString() {
        return value;
    }
}
