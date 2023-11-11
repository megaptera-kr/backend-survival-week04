package kr.megaptera.assignment.models;

import java.util.Objects;

public class PostAuthor {
    private String author;

    public PostAuthor(String author) {
        this.author = author;
    }

    public static PostAuthor of(String author){
        return new PostAuthor(author);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostAuthor that = (PostAuthor) o;
        return Objects.equals(author, that.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author);
    }

    @Override
    public String toString() {
        return author;
    }
}
