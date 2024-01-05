package kr.megaptera.assignment.models.Post;

public class Post {
    private final PostId id;
    private final Author author;
    private PostTitle title;

    private PostContent content;

    public Post(PostTitle title, Author author, PostContent content) {
        this.id = PostId.generate();
        this.author = author;
        this.title = title;
        this.content = content;
    }

    public PostId id() {
        return id;
    }

    public Author author() {
        return author;
    }

    public PostTitle title() {
        return title;
    }

    public PostContent content() {
        return content;
    }

    public void update(PostTitle postTitle, PostContent postContent) {
        this.title = postTitle;
        this.content = postContent;
    }
}
