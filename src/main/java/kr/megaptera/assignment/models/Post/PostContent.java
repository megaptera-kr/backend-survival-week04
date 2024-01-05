package kr.megaptera.assignment.models.Post;

public class PostContent {

    private String value;

    private PostContent(String value) {
        this.value = value;
    }

    public static PostContent of(String value) {
        return new PostContent(value);
    }

    @Override
    public String toString() {
        return value;
    }
}
