package kr.megaptera.assignment.model;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class MultiLineText {
    private List<String> lines;

    public MultiLineText(String text) {
        this.lines = Arrays.asList(text.split("\n"));
    }

    public static MultiLineText of(String text) {
        return new MultiLineText(text);
    }

    @Override
    public String toString() {
        return String.join("\n", lines);
    }
    @Override
    public boolean equals(Object other) {
        MultiLineText multilineText = (MultiLineText) other;

        return Objects.equals(lines, multilineText.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines);
    }

}
