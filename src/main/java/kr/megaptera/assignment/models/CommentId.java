package kr.megaptera.assignment.models;

import com.github.f4b6a3.tsid.Tsid;
import com.github.f4b6a3.tsid.TsidCreator;
import kr.megaptera.assignment.exceptions.CommentException;

public record CommentId(String id) implements Comparable<CommentId> {
    public static CommentId generate() {
        return new CommentId(TsidCreator.getTsid().toString());
    }

    public static CommentId of(String id) {
        if (!Tsid.isValid(id)) {
            throw new CommentException();
        }
        return new CommentId(id);
    }

    @Override
    public int compareTo(CommentId o) {
        return id.compareTo(o.id);
    }

    @Override
    public String toString() {
        return id;
    }
}
