package kr.megaptera.assignment.models;

public class Post {
    private PostId id;

    private Title title;

    private Author author;

    private MultilineText content;

    public Post(PostId id, Title title, Author author, MultilineText content) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.content = content;
    }

    public Post(Title title, Author author, MultilineText content) {
        this.id = PostId.generate();
        this.title = title;
        this.author = author;
        this.content = content;
    }

    public PostId id() {
        return id;
    }

    public Title title() {
        return title;
    }

    public Author author() {
        return author;
    }

    public MultilineText content() {
        return content;
    }

    public void update(String title, String content) {
        this.title = Title.of(title);
        this.content = MultilineText.of(content);
    }
}
