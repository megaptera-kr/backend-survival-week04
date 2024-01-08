package kr.megaptera.assignment.domain.comment;

import com.github.f4b6a3.tsid.TsidCreator;
import kr.megaptera.assignment.domain.post.MultilineText;

import java.util.Objects;

public class Comment {

    private CommentId id;

    private String author;

    private MultilineText content;

    public Comment(CommentId id, String author, MultilineText content) {
        this.id = id;
        this.author = author;
        this.content = content;
    }

    public Comment(String author, MultilineText content) {
        this.id = CommentId.of(TsidCreator.getTsid().toString());
        this.author = author;
        this.content = content;
    }

    public CommentId id() {
        return id;
    }

    public String author() {
        return author;
    }

    public MultilineText content() {
        return content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return Objects.equals(id, comment.id) && Objects.equals(author, comment.author) && Objects.equals(content, comment.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, author, content);
    }

    public void update(MultilineText content) {
        this.content = content;
    }
}
