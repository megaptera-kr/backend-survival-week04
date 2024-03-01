package kr.megaptera.assignment.models;

public class PostTitle {
    private String title;

    public PostTitle(String title) {
        this.title = title;
    }

    public static PostTitle of(String title){
        return new PostTitle(title);
    }

    @Override
    public String toString() {
        return title;
    }
}
