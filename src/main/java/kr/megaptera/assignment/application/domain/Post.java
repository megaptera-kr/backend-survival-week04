package kr.megaptera.assignment.application.domain;

import kr.megaptera.assignment.dtos.PostUpdateRequestDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Post {
    private PostId id;
    private String title;
    private String author;
    private String content;

    public void setId(PostId id) {
        this.id = id;
    }

    @Builder
    private Post(PostId id, String title, String author, String content) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.content = content;
    }

    public void update(PostUpdateRequestDTO requestDTO) {
        if (requestDTO.title() != null) {
            this.title = requestDTO.title();
        }

        if (requestDTO.content() != null) {
            this.content = requestDTO.content();
        }
    }
}
