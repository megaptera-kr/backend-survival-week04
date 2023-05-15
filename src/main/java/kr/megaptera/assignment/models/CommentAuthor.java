package kr.megaptera.assignment.models;

import java.util.Objects;

public class CommentAuthor {

    private String author;

    public CommentAuthor(String author) {
        this.author = author;
    }

    public static CommentAuthor of(String author) {
        return new CommentAuthor(author);
    }

    @Override
    public String toString() {
        return author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CommentAuthor that)) return false;
        return Objects.equals(author, that.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author);
    }
}
