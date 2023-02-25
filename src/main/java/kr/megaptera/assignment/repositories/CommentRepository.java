package kr.megaptera.assignment.repositories;

import kr.megaptera.assignment.dtos.comment.CommentCreateDto;
import kr.megaptera.assignment.dtos.comment.CommentDto;

import java.util.HashMap;
import java.util.List;

public class CommentRepository {

    // 전체 해시맵 => Key: 게시글 아이디, Value: 댓글 해시맵
    // 댓글 해시맵 => key: 댓글 아이디, value: 댓글Dto
    HashMap<String, HashMap<String, CommentDto>> commentMap = new HashMap<>();

    private Long id = 0L;

    // 아이디 하나씩 커지는 메서드
    private String getNewId() {
        id += 1;
        return id.toString();
    }

    public List<CommentDto> getCommentList(String postId) {
        // 특정 게시물 아이디의 댓글 해시맵의 value 리스트를 리턴
        if (!commentMap.containsKey(postId)) {
            // 댓글이 없는 게시글인 경우 빈 목록 생성
            HashMap<String, CommentDto> initialCommentMap = new HashMap<>();
            commentMap.put(postId, initialCommentMap);

            return initialCommentMap.values().stream().toList();
        } else {
            // 댓글이 있으면 리턴
            return commentMap.get(postId).values().stream().toList();
        }
    }

    public CommentDto createComment(String postId, CommentCreateDto commentCreateDto) {

        CommentDto newComment = new CommentDto(getNewId(),
                commentCreateDto.getAuthor(), commentCreateDto.getContent());

        if (commentMap.containsKey(postId)) {
            //이미 댓글이 있는 게시글 이라면 댓글 추가
            commentMap.get(postId).put(newComment.getId(), newComment);
        } else {
            // 첫 댓글 게시물이라면 새로 생성
            HashMap<String, CommentDto> newCommentHashMap = new HashMap<>();
            newCommentHashMap.put(newComment.getId(), newComment);

            commentMap.put(postId, newCommentHashMap);
        }

        return newComment;
    }

    public CommentDto updateComment(String postId, String commentId, String content) {
        CommentDto updateTargetComment = commentMap.get(postId).get(commentId);

        // 새로운 내용 업데이트
        updateTargetComment.setContent(content);

        return updateTargetComment;
    }

    public CommentDto deleteComment(String postId, String commentId) {
        CommentDto removedComment = commentMap.get(postId).remove(commentId);
        return removedComment;
    }
}
