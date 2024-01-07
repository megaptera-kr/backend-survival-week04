package kr.megaptera.assignment.models.post;

public class Post {
    private final PostId id;
    private final PostAuthor postAuthor;
    private PostTitle title;

    private PostContent content;

    public Post(PostTitle title, PostAuthor postAuthor, PostContent content) {
        this.id = PostId.generate();
        this.postAuthor = postAuthor;
        this.title = title;
        this.content = content;
    }

    public PostId id() {
        return id;
    }

    public PostAuthor author() {
        return postAuthor;
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
