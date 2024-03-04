package kr.megaptera.assignment.models;

import com.github.f4b6a3.tsid.TsidCreator;

public class PostId {
    private String id;

    public PostId(){
        this.id = TsidCreator.getTsid().toString();
    }

    public PostId(String id) {
        this.id = id;
    }

    public static PostId of(String id){
        return new PostId(id);
    }

    @Override
    public String toString() {
        return id;
    }
}
