package kr.megaptera.assignment.models;

public class Post {

    private PostId id;

    private Title title;

    private Author author;

    private Content content;

    public Post(Title title, Author author, Content content) {
        this.title = title;
        this.author = author;
        this.content = content;
    }

    public PostId getId() {
        return id;
    }

    public Title getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public Content getContent() {
        return content;
    }

    public boolean isEqualId(PostId postId) {
        return this.id.equals(postId);
    }

    public void createId(PostId postId) {
        this.id = postId;
    }
}
