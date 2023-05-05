package kr.megaptera.assignment.models;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class PostText {
    private List<String> content;

    public PostText(String content) {
        this.content = Arrays.asList(content.split("\n"));
    }

    public static PostText of(String content){
        return new PostText(content);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostText postText = (PostText) o;
        return Objects.equals(content, postText.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content);
    }

    @Override
    public String toString() {
        return content.stream().collect(Collectors.joining("\n"));
    }
}


