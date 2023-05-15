package kr.megaptera.assignment.models;

import java.util.Objects;

public class PostTitle {

    private String title;

    public PostTitle(String title) {
        this.title = title;
    }

    public static PostTitle of(String title) {
        return new PostTitle(title);
    }

    public String getTitle() {
        return this.title;
    }

    @Override
    public String toString() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PostTitle postTitle)) return false;
        return Objects.equals(title, postTitle.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

}
