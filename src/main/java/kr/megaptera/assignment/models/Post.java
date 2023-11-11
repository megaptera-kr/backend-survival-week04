package kr.megaptera.assignment.models;

import com.github.f4b6a3.tsid.TsidCreator;
import kr.megaptera.assignment.dtos.PostDto;

public class Post {
    private PostId id;
    private PostTitle title;
    private PostAuthor author;
    private MultilineText content;

    public Post(PostTitle title, PostAuthor author, MultilineText content) {
        this.id = PostId.of(generate());
        this.title = title;
        this.author = author;
        this.content = content;
    }

    public PostId id(){
        return id;
    }
    public PostTitle title(){
        return title;
    }
    public PostAuthor author(){
        return author;
    }
    public MultilineText content(){
        return content;
    }

    private static String generate() {
        return TsidCreator.getTsid().toString();
    }

    public void update(PostTitle title, MultilineText content) {
        this.title = title;
        this.content = content;
    }
}
