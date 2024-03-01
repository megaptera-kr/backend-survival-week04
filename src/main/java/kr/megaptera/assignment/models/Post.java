package kr.megaptera.assignment.models;

public class Post {
    private PostId id;
    private PostTitle title;
    private Author author;
    private PostContent content;

    public Post() {
    }

    public Post(PostId id, PostTitle title, Author author, PostContent content) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.content = content;
    }

    public Post(Post originPost, PostTitle title, PostContent content) {
        this.id = originPost.id();
        this.author = originPost.author();
        this.title = title;
        this.content = content;
    }


    public PostId id() {
        return id;
    }

    public PostTitle title() {
        return title;
    }

    public Author author() {
        return author;
    }

    public PostContent postContent() {
        return content;
    }

    public void setId(PostId id) {
        this.id = id;
    }
}
