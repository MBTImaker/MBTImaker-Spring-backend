package project.mbti.comment;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;
import project.mbti.comment.dto.CommentDto;
import project.mbti.comment.entity.Comment;
import project.mbti.comment.entity.MBTI;
import project.mbti.exception.CommentNameNotMatchException;
import project.mbti.exception.CommentNotFoundException;
import project.mbti.exception.CommentPasswordNotMatchException;


import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Transactional
@DisplayName("댓글_로직_테스트")
@SpringBootTest
class CommentServiceTest {

    @Autowired
    CommentService commentService;
    @Autowired
    CommentRepository commentRepository;

    @Test
    @DisplayName("댓글_작성")
    void write_comment() throws Exception {
        // given
        final MBTI mbti = MBTI.ISTJ;
        final String name = "만두";
        final String password = "1234";
        final String content = "우와 신기해요!";

        // when
        final Comment comment = commentService.create(mbti, name, password, content, null);

        // then
        assertThat(commentService.findById(comment.getId()).get().getContent()).isEqualTo(content);
    }

    @Test
    @DisplayName("댓글_작성_비속어_필터링")
    void write_comment_filtering() throws Exception {
        // given
        final MBTI mbti = MBTI.ISTJ;
        final String name = "만두";
        final String password = "1234";
        final String content = "fuck!!! 개자식아";

        // when
        final Comment comment = commentService.create(mbti, name, password, content, null);

        // then
        assertThat(commentService.findById(comment.getId()).get().getContent()).isEqualTo("****!!! ***아");
    }

    @Test
    @DisplayName("댓글_삭제")
    void delete_comment() throws Exception {
        // given
        final MBTI mbti = MBTI.ISTJ;
        final String name = "만";
        final String password = "1234";
        final String content = "우와 신기해요!";
        final Comment comment = commentService.create(mbti, name, password, content, null);

        // when
        commentService.delete(comment.getId(), comment.getName(), comment.getPassword());

        // then
        assertThat(commentService.findById(1L)).isEqualTo(Optional.empty());
    }

    @Test
    @DisplayName("댓글_삭제_예외")
    void delete_comment_exception() throws Exception {
        // given
        final MBTI mbti = MBTI.ISTJ;
        final String name = "만두";
        final String password = "1234";
        final String content = "우와 신기해요!";
        final Comment comment = commentService.create(mbti, name, password, content, null);

        // when
        Long wrongId = 2L;
        String wrongName = "찐빵";
        String wrongPassword = "4321";

        // then
        assertThrows(CommentNotFoundException.class, () -> {
            commentService.delete(wrongId, comment.getName(), comment.getPassword());
        });
        assertThrows(CommentNameNotMatchException.class, () -> {
            commentService.delete(comment.getId(), wrongName, comment.getPassword());
        });
        assertThrows(CommentPasswordNotMatchException.class, () -> {
            commentService.delete(comment.getId(), comment.getName(), wrongPassword);
        });
    }

    @Test
    @DisplayName("댓글_페이징")
    void paging_comment() throws Exception {
        // given
        final MBTI mbti = MBTI.ISTJ;
        final String name = "만";
        final String password = "1234";
        final String content = "우와 신기해요!";
        final Comment comment = commentService.create(mbti, name, password, content, null);
        final Comment comment2 = commentService.create(mbti, name, password, content, null);
        final Comment comment3 = commentService.create(mbti, name, password, content, null);

        // when
        final Page<CommentDto> commentPage = commentService.getCommentPage(0, mbti);

        // then
        assertThat(commentPage.getTotalElements()).isEqualTo(3);
        assertThat(commentPage.getContent().get(0).getId()).isEqualTo(comment3.getId());
    }
}
