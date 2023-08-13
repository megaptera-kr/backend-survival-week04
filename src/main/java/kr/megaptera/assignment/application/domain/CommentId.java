package kr.megaptera.assignment.application.domain;

import kr.megaptera.assignment.exceptions.ParsingException;

import java.util.Objects;

public record CommentId(Long commentId) {
    public static CommentId of(String id) {
        long commentId;

        try {
            commentId = Long.parseLong(id);
        } catch (NumberFormatException e) {
            throw new ParsingException();
        }

        return new CommentId(commentId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CommentId commentId1)) return false;
        return Objects.equals(commentId, commentId1.commentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(commentId);
    }

    @Override
    public String toString() {
        return String.valueOf(commentId);
    }
}
