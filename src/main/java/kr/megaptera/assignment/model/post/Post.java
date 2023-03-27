package kr.megaptera.assignment.model.post;

public class Post {
    private PostId id;
    private String author;
    private String title;
    private MultiLineText content;

    public Post(PostId id, String author, String title, MultiLineText content) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.content = content;
    }

    public Post(String author, String title, MultiLineText content) {
        this.id = PostId.generate();
        this.author = author;
        this.title = title;
        this.content = content;
    }

    public void update(String title, MultiLineText content) {
        this.title = title;
        this.content = content;
    }

    public PostId id() {
        return id;
    }

    public String title() {
        return title;
    }

    public String author() {
        return author;
    }

    public MultiLineText content() {
        return content;
    }
}
