package kr.megaptera.assignment.models;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MultilineContent {
    private List<String> multiLineContent;

    public MultilineContent(String content) {
        this.multiLineContent = Arrays.asList(content.split("\n"));
    }

    @Override
    public String toString(){
        return multiLineContent.stream().collect(Collectors.joining("\n"));
    }

    public static MultilineContent of(String content){
        return new MultilineContent(content);
    }


}
