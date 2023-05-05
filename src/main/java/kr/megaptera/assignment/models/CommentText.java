package kr.megaptera.assignment.models;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CommentText {
    private List<String> line;

    public CommentText(String content) {
        this.line = Arrays.asList(content.split("\n"));
    }

    @Override
    public String toString() {
        return line.stream().collect(Collectors.joining("\n"));
    }

    public static CommentText of(String content){
        return new CommentText(content);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommentText that = (CommentText) o;
        return Objects.equals(line, that.line);
    }

    @Override
    public int hashCode() {
        return Objects.hash(line);
    }
}
