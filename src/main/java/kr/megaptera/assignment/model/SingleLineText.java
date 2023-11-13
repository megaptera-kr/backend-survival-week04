package kr.megaptera.assignment.model;

import java.util.Objects;

public class SingleLineText {
    private String text;

    public SingleLineText(String text) {
        this.text = text;
    }

    public static SingleLineText of(String text){
        return new SingleLineText(text);
    }

    @Override
    public String toString(){
        return text;
    }

    @Override
    public boolean equals(Object other) {
        SingleLineText otherSingleLineText = (SingleLineText) other;

        return Objects.equals(text, otherSingleLineText.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text);
    }

}
