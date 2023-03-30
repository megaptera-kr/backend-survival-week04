package kr.megaptera.assignment.services;

import com.github.f4b6a3.tsid.TsidCreator;
import kr.megaptera.assignment.dtos.PostCreateDto;
import kr.megaptera.assignment.models.Post;
import org.springframework.stereotype.Component;

@Component
public class NewPostFactory {
    public Post create(PostCreateDto source) {
        var id = TsidCreator.getTsid().toString();
        return new Post(
                id,
                source.getTitle(),
                source.getAuthor(),
                source.getContent());
    }
}
