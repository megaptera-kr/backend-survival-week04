package kr.megaptera.assignment;

import kr.megaptera.assignment.models.Post;
import kr.megaptera.assignment.models.PostId;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class AssignmentApplicationTests {

	Map<PostId, Post> testPosts;

	@Test
	void contextLoads() {

		testPosts = new HashMap<>();

		Post post = new Post("title","author","content");
		testPosts.put(post.id(), post);

		PostId id = post.id();
		PostId reqId = PostId.of(id.toString());

		Post findPost = testPosts.get(id);
		Post findPost2 = testPosts.get(reqId);

		System.out.println(findPost);
		System.out.println(findPost2);
	}

}
