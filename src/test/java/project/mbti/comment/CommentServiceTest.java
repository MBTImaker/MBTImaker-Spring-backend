package project.mbti.comment;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.*;
import org.springframework.test.util.ReflectionTestUtils;
import project.mbti.MBTI;
import project.mbti.comment.dto.CommentDto;
import project.mbti.comment.entity.Comment;
import project.mbti.comment.entity.CommentState;
import project.mbti.exception.CommentNameNotMatchException;
import project.mbti.exception.CommentNotFoundException;
import project.mbti.exception.CommentPasswordNotMatchException;
import project.mbti.exception.InvalidMbtiException;
import project.mbti.report.ReportRepository;
import project.mbti.util.BadWordsFilter;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CommentServiceTest {

    @Mock
    private CommentRepository commentRepository;

    @Mock
    private ReportRepository reportRepository;

    @Mock
    private EntityManager em;

    @Mock
    BadWordsFilter badWordsFilter;

    @InjectMocks
    private CommentService commentService;

    @Test
    @DisplayName("댓글 생성: 비속어 필터링")
    void create() throws Exception {
        // given
        Comment comment = Comment.builder()
                .name("만두")
                .password("1234")
                .mbti(MBTI.ISTJ)
                .content("shit!!")
                .parent(Optional.empty())
                .build();
        ReflectionTestUtils.setField(comment, "id", 1L);

        Comment filteredComment = Comment.builder()
                .name("만두")
                .password("1234")
                .mbti(MBTI.ISTJ)
                .content("****!!")
                .parent(Optional.empty())
                .build();
        ReflectionTestUtils.setField(filteredComment, "id", 1L);

        doReturn("****!!").when(badWordsFilter).filterText("shit!!");
        doReturn(filteredComment).when(commentRepository).save(any(Comment.class));

        // when
        final Comment savedComment = commentService.create(comment.getMbti(), comment.getName(), comment.getPassword(), comment.getContent(), 0L);

        // then
        verify(commentRepository, times(1)).save(any(Comment.class));
        assertThat(comment.getId()).isEqualTo(savedComment.getId());
        assertThat(comment.getName()).isEqualTo(savedComment.getName());
        assertThat(comment.getPassword()).isEqualTo(savedComment.getPassword());
        assertThat(comment.getContent()).isNotEqualTo(savedComment.getContent());
    }

   @Test
   @DisplayName("댓글 생성 예외1: 유효하지 않은 MBTI 입력")
   void create_ex1() throws Exception {
       // given
       final Comment comment = Comment.builder()
               .name("만두")
               .password("1234")
               .mbti(MBTI.NOT_FOUND)
               .content("댓글!")
               .parent(Optional.empty())
               .build();

       // when
       final Executable create = () -> commentService.create(comment.getMbti(), comment.getName(), comment.getPassword(), comment.getContent(), 0L);

       // then
       assertThrows(InvalidMbtiException.class, create);
   }

   @Test
   @DisplayName("댓글 삭제")
   void delete() throws Exception {
       // given
       Comment comment = Comment.builder()
               .name("만두")
               .password("1234")
               .mbti(MBTI.ISTJ)
               .content("댓글!")
               .parent(Optional.empty())
               .build();
       ReflectionTestUtils.setField(comment, "id", 1L);

       doNothing().when(reportRepository).bulkUpdateReportStateByCommentId(any(Long.class));
       doNothing().when(em).flush();
       doReturn(Optional.of(comment)).when(commentRepository).findById(any(Long.class));

       // when
       commentService.delete(comment.getId(), comment.getName(), comment.getPassword());

       // then
       assertThat(comment.getState()).isEqualTo(CommentState.DELETED);
   }

   @Test
   @DisplayName("댓글 삭제 예외1: 존재하지 않는 댓글")
   void delete_ex1() throws Exception {
       // given
       doThrow(new CommentNotFoundException()).when(commentRepository).findById(any(Long.class));

       // when
       final Executable delete = () -> commentService.delete(1L, "만두", "1234");

       // then
       assertThrows(CommentNotFoundException.class, delete);
   }

   @Test
   @DisplayName("댓글 삭제 예외2: 작성자 이름 불일치")
   void delete_ex2() throws Exception {
       // given
       Comment comment = Comment.builder()
               .name("만두")
               .password("1234")
               .mbti(MBTI.ISTJ)
               .content("댓글!")
               .parent(Optional.empty())
               .build();

       doReturn(Optional.of(comment)).when(commentRepository).findById(any(Long.class));

       // when
       final Executable delete = () -> commentService.delete(1L, "구름", "1234");

       // then
       assertThrows(CommentNameNotMatchException.class, delete);
   }

   @Test
   @DisplayName("댓글 삭제 예외3: 작성자 비밀번호 불일치")
   void delete_ex3() throws Exception {
       // given
       Comment comment = Comment.builder()
               .name("만두")
               .password("1234")
               .mbti(MBTI.ISTJ)
               .content("댓글!")
               .parent(Optional.empty())
               .build();

       doReturn(Optional.of(comment)).when(commentRepository).findById(any(Long.class));

       // when
       final Executable delete = () -> commentService.delete(1L, "만두", "4321");

       // then
       assertThrows(CommentPasswordNotMatchException.class, delete);
   }

   @Test
   @DisplayName("댓글 페이징 조회")
   void getCommentPage() throws Exception {
       // given
       List<CommentDto> commentDtos = new ArrayList<>();
       for (int i = 0; i < 5; i++) {
           Comment comment = Comment.builder()
                   .name("만두" + i)
                   .password("1234")
                   .mbti(MBTI.ISTJ)
                   .content("안녕" + i)
                   .parent(java.util.Optional.empty())
                   .build();
           ReflectionTestUtils.setField(comment, "id", (long) i);

           commentDtos.add(comment.convert());
       }

       final Pageable pageable = PageRequest.of(0, 10, Sort.by(Sort.Direction.DESC, "id"));
       final Page<CommentDto> page = new PageImpl<>(commentDtos);

       doReturn(page).when(commentRepository).findCommentDtoPage(pageable);

       // when
       final Page<CommentDto> commentPage = commentService.getCommentPage(1, 10);

       // then
       assertThat(commentPage.getTotalElements()).isEqualTo(5);
   }
}