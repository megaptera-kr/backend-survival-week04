package kr.megaptera.assignment.models;

import com.github.f4b6a3.tsid.Tsid;
import com.github.f4b6a3.tsid.TsidCreator;
import kr.megaptera.assignment.exceptions.PostException;

import java.util.Objects;

public record PostId(String id) implements Comparable<PostId> {

    public static PostId generate() {
        return new PostId(TsidCreator.getTsid().toString());
    }

    public static PostId of(String id) {
        if (!Tsid.isValid(id)) {
            throw new PostException();
        }

        return new PostId(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostId postId = (PostId) o;
        return Objects.equals(id, postId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    @Override
    public int compareTo(PostId o) {
        return this.id.compareTo(o.id);
    }

    @Override
    public String toString() {
        return id;
    }
}
