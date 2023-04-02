package kr.megaptera.assignment.dtos;

public class CommentUpdatedDTO {
    private String content;

    public CommentUpdatedDTO() {
    }

    public CommentUpdatedDTO(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
