package kr.megaptera.assignment.model;

public class Post {
    private PostId id;
    private SingleLineText title;
    private SingleLineText author;
    private MultiLineText content;

    public Post(PostId id, SingleLineText title, SingleLineText author, MultiLineText content) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.content = content;
    }

    public Post(SingleLineText title, SingleLineText author, MultiLineText content) {
        this.id = new PostId("99");
        this.title = title;
        this.author = author;
        this.content = content;
    }

    public PostId id() {
        return id;
    }

    public SingleLineText title() {
        return title;
    }

    public SingleLineText author() {
        return author;
    }

    public MultiLineText content() {
        return content;
    }

    public void update(SingleLineText title,
                       SingleLineText author,
                       MultiLineText content) {
        this.title = title;
        this.author = author;
        this.content = content;
    }
}
