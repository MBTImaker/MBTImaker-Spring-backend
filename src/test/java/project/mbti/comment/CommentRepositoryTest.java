package project.mbti.comment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import project.mbti.MBTI;
import project.mbti.comment.dto.CommentDto;
import project.mbti.comment.entity.Comment;
import project.mbti.comment.entity.CommentState;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @DataJpaTest
 * JPA 관련된 설정만 로드한다. (WebMVC와 관련된 Bean이나 기능은 로드되지 않는다)
 * JPA를 사용해서 생성/조회/수정/삭제 기능의 테스트가 가능하다.
 * @Transactional 을 기본적으로 내장하고 있으므로, 매 테스트 코드가 종료되면 자동으로 DB가 롤백된다.
 * 기본적으로 내장 DB를 사용하는데, 설정을 통해 실제 DB로 테스트도 가능하다. (권장하지 않는다)
 * @Entity 가 선언된 클래스를 스캔하여 저장소를 구성한다.
 */
@DataJpaTest
class CommentRepositoryTest {

    @Autowired
    private CommentRepository commentRepository;

    @BeforeEach
    private void init() {
        for (int i = 0; i < 5; i++) {
            Comment comment = Comment.builder()
                    .name("만두" + i)
                    .password("1234")
                    .mbti(MBTI.ISTJ)
                    .content("안녕" + i)
                    .parent(java.util.Optional.empty())
                    .build();

            commentRepository.save(comment);
        }

        for (int i = 5; i < 10; i++) {
            Comment comment = Comment.builder()
                    .name("만두" + i)
                    .password("1234")
                    .mbti(MBTI.ISTJ)
                    .content("안녕" + i)
                    .parent(java.util.Optional.empty())
                    .build();

            commentRepository.save(comment);
            comment.updateState(CommentState.DELETED);
        }
    }

    @Test
    @DisplayName("댓글 페이징 조회: WRITTEN만 조회 성공")
    void findCommentDtoPage() throws Exception {
        // given
        Pageable pageable = PageRequest.of(1, 10);

        // when
        final Page<CommentDto> commentDtoPage = commentRepository.findCommentDtoPage(pageable);

        // then
        assertThat(commentDtoPage.getTotalElements()).isEqualTo(5);
    }
}