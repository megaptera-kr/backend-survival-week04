package kr.megaptera.assignment.application;

import kr.megaptera.assignment.dtos.PostCreateRequestDTO;
import kr.megaptera.assignment.dtos.PostCreateResponseDTO;
import kr.megaptera.assignment.dtos.PostDeleteResponseDTO;
import kr.megaptera.assignment.dtos.PostGetResponseDTO;
import kr.megaptera.assignment.dtos.PostUpdateRequestDTO;
import kr.megaptera.assignment.dtos.PostUpdateResponseDTO;
import kr.megaptera.assignment.exceptions.PostIdParsingException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    public List<PostGetResponseDTO> list() {
        return null;
    }

    public PostGetResponseDTO get(String id) {
        Long postId =  parsingLong(id);
        return null;
    }


    public PostCreateResponseDTO create(PostCreateRequestDTO requestDTO) {
        return null;
    }
    public PostUpdateResponseDTO update(String id, PostUpdateRequestDTO requestDTO) {
        Long postId = parsingLong(id);
        return null;
    }

    public PostDeleteResponseDTO delete(String id) {
        Long postId = parsingLong(id);
        return null;
    }

    private Long parsingLong(String id) {
        Long postId;
        try {
            postId = Long.parseLong(id);
        } catch (NumberFormatException e) {
            throw new PostIdParsingException();
        }

        return postId;
    }
}
