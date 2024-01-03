package kr.megaptera.assignment.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MultiLineText {
    private List<String> text = new ArrayList<>();

    public MultiLineText(String initialText) {
        this.text = new ArrayList<>(Arrays.asList(initialText.split("\n")));
    }

    public void reset() {
        text = new ArrayList<>();
    }

    public String text() {
        return String.join("\n", text);
    }

    public List<String> textList() {
        return List.copyOf(text);
    }

    @Override
    public String toString() {
        return text();
    }

    public static MultiLineText of(String text) {
        return new MultiLineText(text);
    }
}
