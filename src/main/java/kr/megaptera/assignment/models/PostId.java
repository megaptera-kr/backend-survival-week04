package kr.megaptera.assignment.models;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PostId {

    private String value;

    public static PostId of(String value) { //String to PostId
        return new PostId(value);
    }

    @Override
    public String toString() {
        return this.value;
    }
}
