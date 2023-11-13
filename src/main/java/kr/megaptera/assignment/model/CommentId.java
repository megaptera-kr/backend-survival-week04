package kr.megaptera.assignment.model;

import java.util.Objects;

public class CommentId {
    private String id;

    public CommentId(String id) {
        this.id = id;
    }

    public static CommentId of(String id){
        return new CommentId(id);
    }

    @Override
    public String toString(){
        return id;
    }

    @Override
    public boolean equals(Object other) {
        CommentId otherCommentId = (CommentId) other;

        return Objects.equals(id, otherCommentId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

