package kr.megaptera.assignment.model;

import com.github.f4b6a3.tsid.TsidCreator;

import java.util.Objects;

public class PostId {
    private String value;

    public PostId(String value) {
        this.value = value;
    }

    public static PostId of(String value) {
        return new PostId(value);
    }

    public String toString() {
        return this.value;
    }

    public static PostId generate() {

        return new PostId(TsidCreator.getTsid().toString());
    }

    public boolean equals(Object other) {
        PostId otherPostId = (PostId) other;

        return Objects.equals(value, otherPostId.value);
    }

    public int hashCode() {
        return Objects.hash(value);
    }
}
