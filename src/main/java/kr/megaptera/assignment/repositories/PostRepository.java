package kr.megaptera.assignment.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.megaptera.assignment.exceptions.PostNotFound;
import kr.megaptera.assignment.models.Post;
import kr.megaptera.assignment.models.PostId;

public class PostRepository {
	Map<PostId, Post> posts;

	public PostRepository() {
		this.posts = new HashMap<>();
	}

	public List<Post> findAll() {
		return new ArrayList<>(posts.values());
	}

	public Post find(PostId id) {
		Post post = posts.get(id);

		if (post == null) {
			throw new PostNotFound();
		}

		return post;
	}

	public void save(Post post) {
		posts.put(post.id(), post);
	}

	public void delete(PostId id) {
		posts.remove(id);
	}
}
