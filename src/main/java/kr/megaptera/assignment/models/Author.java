package kr.megaptera.assignment.models;

public class Author {
    private String authorId;
    public static Author of(String id){
        return new Author(id);
    }

    public Author(String authorId) {
        this.authorId = authorId;
    }

    @Override
    public String toString() {
        return authorId;
    }
}
