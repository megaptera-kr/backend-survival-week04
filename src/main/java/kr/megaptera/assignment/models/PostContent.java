package kr.megaptera.assignment.models;

public class PostContent {
    private MultilineContent content;

    public static PostContent of(String content){
        return new PostContent(MultilineContent.of(content));
    }

    public PostContent(String content) {
        this.content = new MultilineContent(content);
    }

    public PostContent(MultilineContent content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return content.toString();
    }
}
