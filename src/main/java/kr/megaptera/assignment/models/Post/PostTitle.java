package kr.megaptera.assignment.models.Post;

public class PostTitle {

    private String value;

    private PostTitle(String value) {
        this.value = value;
    }

    public static PostTitle of(String value) {
        return new PostTitle(value);
    }

    @Override
    public String toString() {
        return value;
    }
}
