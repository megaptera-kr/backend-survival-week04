package kr.megaptera.assignment.models;

public class Post {
    private PostId id;
    private PostTitle title;
    private String author;

    private PostText content;

    public Post(PostId id, PostTitle title, String author, PostText content) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.content = content;
    }

    public Post(PostTitle title, String author, PostText content) {
        this.id = PostId.generate();
        this.title = title;
        this.author = author;
        this.content = content;
    }

    public PostId id() {
        return id;
    }

    public PostTitle title() {
        return title;
    }
    public  PostText content(){
        return content;
    }

    public String author() {
        return author;
    }

    public void update(PostTitle title, PostText content) {
        this.title = title;
        this.content = content;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title=" + title +
                ", author='" + author + '\'' +
                ", content=" + content +
                '}';
    }
}

