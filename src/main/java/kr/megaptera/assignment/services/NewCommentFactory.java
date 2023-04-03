package kr.megaptera.assignment.services;

import com.github.f4b6a3.tsid.TsidCreator;
import kr.megaptera.assignment.dtos.CommentCreateDto;
import kr.megaptera.assignment.models.Comment;
import org.springframework.stereotype.Component;

@Component
public class NewCommentFactory {
    public Comment create(String postId, CommentCreateDto source){
        var id = TsidCreator.getTsid().toString();
        return new Comment(
                id,
                postId,
                source.getAuthor(),
                source.getContent());
    }
}
