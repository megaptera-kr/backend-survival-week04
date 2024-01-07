package kr.megaptera.assignment.models.post;

import com.github.f4b6a3.tsid.TsidCreator;

public class PostId {

    private final String value;

    private PostId(String value) {
        this.value = value;
    }


    // Create immutable object PostId with static factory method
    public static PostId of(String value) {
        return new PostId(value);
    }

    // Generate random PostId
    public static PostId generate() {
        return new PostId(TsidCreator.getTsid().toString());
    }

    @Override
    public String toString() {
        return value;
    }

    // Override equals() and hashCode() to compare PostId objects
    // by value instead of by reference
    // Map<PostId, Post> posts 에서 key는 유일해야 함
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PostId postId)) return false;

        return value.equals(postId.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
