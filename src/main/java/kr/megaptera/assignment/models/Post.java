package kr.megaptera.assignment.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import com.github.f4b6a3.tsid.TsidCreator;
import lombok.NoArgsConstructor;

@Data
//@AllArgsConstructor
@NoArgsConstructor
public class Post {
    private PostId id;  //Updated type for Hashmap key : String -> PostId
    private String title;
    private String author;
    private String content;

    public Post(PostId id, String title, String author, String content) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.content = content;
    }

    public Post(String title, String author, String content) {
        this.id = PostId.generate();
        this.title = title;
        this.author = author;
        this.content = content;
    }

    public PostId id() {
        return id;
    }
}
