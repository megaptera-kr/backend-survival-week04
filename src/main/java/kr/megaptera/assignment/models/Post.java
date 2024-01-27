package kr.megaptera.assignment.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import com.github.f4b6a3.tsid.TsidCreator;

@Data
@AllArgsConstructor
public class Post {
    private PostId id;  //Updated type for Hashmap key : String -> PostId
    private String title;
    private String author;
    private String content;

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
