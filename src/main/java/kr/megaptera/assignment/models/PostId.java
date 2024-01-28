package kr.megaptera.assignment.models;

import com.github.f4b6a3.tsid.TsidCreator;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
public class PostId {

    private String value;

    public static PostId of(String value) { //String to PostId
        return new PostId(value);
    }

    public static PostId generate() {
        return new PostId(TsidCreator.getTsid().toString());
    }

    @Override
    public String toString() {
        return this.value;
    }

    @Override
    public boolean equals(Object other) {   //Added
        PostId otherPostId = (PostId) other;

        return Objects.equals(value, otherPostId.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }   //역할?
}
