package kr.megaptera.assignment.dtos;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PostId {

    private String value;

    public static PostId of(String value) { //String to PostId
        return new PostId(value);
    }
}
