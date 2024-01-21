package kr.megaptera.assignment.models;

import kr.megaptera.assignment.dtos.PostId;
import lombok.AllArgsConstructor;
import lombok.Data;
import com.github.f4b6a3.tsid.TsidCreator;

@Data
@AllArgsConstructor
public class Post {
    PostId id;  //Updated type for Hashmap key : String -> PostId
    String title;
    String author;
    String content;

    public Post(String title, String author, String content) {
        this.id = new PostId(TsidCreator.getTsid().toString());
        this.title = title;
        this.author = author;
        this.content = content;
    }

    public PostId id() {
        return id;
    }
}
