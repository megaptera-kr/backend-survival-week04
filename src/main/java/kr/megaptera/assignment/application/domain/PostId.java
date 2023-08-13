package kr.megaptera.assignment.application.domain;

import kr.megaptera.assignment.exceptions.ParsingException;

import java.util.Objects;

public record PostId(Long postId) {
    public static PostId of(String id) {
        long postId;

        try {
            postId = Long.parseLong(id);
        } catch (NumberFormatException e) {
            throw new ParsingException();
        }

        return new PostId(postId);
    }

    public static PostId copy(PostId postId) {
        return PostId.of(postId.toString());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PostId postId1)) return false;
        return Objects.equals(postId, postId1.postId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postId);
    }

    @Override
    public String toString() {
        return String.valueOf(this.postId);
    }
}
