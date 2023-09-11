package kr.megaptera.assignment.domain;

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
}
