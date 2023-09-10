package kr.megaptera.assignment.models;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MultiLineText {
    private final List<String> lines;

    public MultiLineText(String text) {
        this.lines = Arrays.asList(text.split("\n"));
    }

    public static MultiLineText of(String text) {
        return new MultiLineText(text);
    }

    @Override
    public String toString() {
        return lines.stream().collect(Collectors.joining("\n"));
    }
}
