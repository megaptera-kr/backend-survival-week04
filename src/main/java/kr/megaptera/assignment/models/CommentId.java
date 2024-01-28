package kr.megaptera.assignment.models;

import com.github.f4b6a3.tsid.TsidCreator;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
public class CommentId {
    private String value;

    public static CommentId of(String value) {
        return new CommentId(value);
    }

    public static CommentId generate() {
        return new CommentId(TsidCreator.getTsid().toString());
    }

    @Override
    public String toString() {
        return this.value;
    }

    @Override
    public boolean equals(Object other) {
        CommentId otherCommentId = (CommentId) other;

        return Objects.equals(value, otherCommentId.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
