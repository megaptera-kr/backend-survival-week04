package kr.megaptera.assignment.models;

public class Post {
    private PostId id;
    private PostTitle title;
    private Author author;
    private PostContent postContent;

    public Post(PostId id, PostTitle title, Author author, PostContent postContent) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.postContent = postContent;
    }

}
