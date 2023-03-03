package kr.megaptera.assignment.model.post;

import java.util.*;

public class MultiLineText {

    private List<String> text;

    public MultiLineText(String text) {
        this.text = Arrays.stream(text.split("\n")).toList();
    }

    public static MultiLineText of(String text) {
        return new MultiLineText(text);
    }

    @Override
    public String toString() {
        return String.join("\n", text);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MultiLineText that = (MultiLineText) o;
        return Objects.equals(text, that.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text);
    }
}
