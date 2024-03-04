package kr.megaptera.assignment.model;

import com.github.f4b6a3.tsid.TsidCreator;

import java.util.Objects;

public class CommentId {
    private String value;

    public CommentId(String value) {
        this.value = value;
    }

    public static CommentId of(String value) {
        return new CommentId(value);
    }

    public String toString() {
        return this.value;
    }

    public static CommentId generate() {

        return new CommentId(TsidCreator.getTsid().toString());
    }

    public boolean equals(Object other) {
        CommentId otherCommentId = (CommentId) other;

        return Objects.equals(value, otherCommentId.value);
    }

    public int hashCode() {
        return Objects.hash(value);
    }
}
