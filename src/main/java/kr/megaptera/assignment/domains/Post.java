package kr.megaptera.assignment.domains;

public class Post {

    private Long id;
    private String title;
    private String author;
    private String content;

    public Post(String title, String author, String content) {
        this.title = title;
        this.author = author;
        this.content = content;
    }

    public void generateId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }

    public void changeTitle(String title) {
        this.title = title;
    }

    public void changeContent(String content) {
        this.content = content;
    }
}
