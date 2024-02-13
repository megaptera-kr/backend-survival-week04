package kr.megaptera.assignment.models;

import com.github.f4b6a3.tsid.TsidCreator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    private CommentId id;
    private PostId postId;
    private String author;
    private String content;

    public Comment(PostId postId, String author, String content) {
        this.id = CommentId.generate();
        this.postId = postId;
        this.author = author;
        this.content = content;
    }
    public CommentId id(){
        return id;
    }
}
