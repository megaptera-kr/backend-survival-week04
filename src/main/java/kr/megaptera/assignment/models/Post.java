package kr.megaptera.assignment.models;

public class Post {
    private PostId id;
    private String title;
    private String author;
    private MultilineText content;

    public Post(PostId id, String title, String author, MultilineText content) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.content = content;
    }

    public Post(String title, String author, MultilineText content) {
        this.id = PostId.generate();
        this.title = title;
        this.author = author;
        this.content = content;
    }

    public void update(String title, MultilineText content) {
        // 내가 고칠 수 있는지 권한 검가
        // title에 대한 유효성 검사
        // 기타 등등 치명적인 무언가...

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

    public MultilineText content() {
        return content;
    }
}
