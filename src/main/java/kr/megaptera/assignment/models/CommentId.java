package kr.megaptera.assignment.models;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CommentId {
    private String value;

    public static CommentId of(String value) {
        return new CommentId(value);
    }

    @Override
    public String toString() {
        return this.value;
    }
}
