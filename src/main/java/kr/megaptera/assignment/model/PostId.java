package kr.megaptera.assignment.model;

import java.util.Objects;

public class PostId {
    private String id;

    public PostId(String id) {
        this.id = id;
    }

    public static PostId of(String id){
        return new PostId(id);
    }

    @Override
    public String toString(){
        return id;
    }

    @Override
    public boolean equals(Object other) {
        PostId otherPostId = (PostId) other;

        return Objects.equals(id, otherPostId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
