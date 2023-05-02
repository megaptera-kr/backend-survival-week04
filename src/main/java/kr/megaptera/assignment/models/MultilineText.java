package kr.megaptera.assignment.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class MultilineText {

    private final List<String> content;

    public MultilineText(String content) {
        this.content = new ArrayList<>(
                Arrays.stream(content.split("\n"))
                        .toList());
    }

    public static MultilineText of(String content) {
        return new MultilineText(content);
    }

    @Override
    public String toString() {
        return content.stream()
                .collect(Collectors.joining("\n"))
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MultilineText that)) return false;
        return Objects.equals(content, that.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content);
    }
}
