package kr.megaptera.assignment.domain;

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
}
