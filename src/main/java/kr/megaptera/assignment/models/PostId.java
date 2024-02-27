package kr.megaptera.assignment.models;

import java.util.Objects;

import com.github.f4b6a3.tsid.TsidCreator;

public class PostId {
	private String value;

	public PostId(String value) {
		this.value = value;
	}

	public static PostId of(String value) {
		return new PostId(value);
	}

	public static PostId generate() {
		return new PostId(TsidCreator.getTsid().toString());
	}

	@Override
	public int hashCode() {
		return Objects.hash(value);
	}

	@Override
	public boolean equals(Object other) {
		PostId otherPostId = (PostId) other;
		return Objects.equals(value, otherPostId.value);
	}

	@Override
	public String toString() {
		return this.value;
	}
}
