package kr.megaptera.assignment.models;

import com.github.f4b6a3.tsid.TsidCreator;

public class CommentId {
    private final String id;

    public CommentId() {
        this.id = TsidCreator.getTsid().toString();
    }

    public CommentId(String id) {
        this.id = id;
    }

    public static CommentId of(String id){
        return new CommentId(id);
    }
}
