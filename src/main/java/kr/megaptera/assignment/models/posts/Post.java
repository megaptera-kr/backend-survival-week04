package kr.megaptera.assignment.models.posts;

public class Post {
    PostId id;
    String title;
    String author;
    String content;

    public Post(PostId id, String title, String author, String content) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.content = content;
    }

    public Post(String title, String author, String content) {
        this(PostId.generate(), title, author, content);
    }

    public PostId id() {
        return this.id;
    }

    public String title() {
        return this.title;
    }

    public String author() {
        return this.author;
    }

    public String content() {
        return this.content;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}