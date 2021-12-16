package project.mbti.comment;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import project.mbti.MBTI;
import project.mbti.comment.dto.CommentDeleteDto;
import project.mbti.comment.dto.CommentDto;
import project.mbti.comment.dto.CommentWriteDto;
import project.mbti.comment.dto.CommentWriteResultType;
import project.mbti.comment.entity.Comment;
import project.mbti.comment.entity.CommentState;
import project.mbti.exception.CommentNameNotMatchException;
import project.mbti.exception.CommentNotFoundException;
import project.mbti.exception.CommentPasswordNotMatchException;
import project.mbti.exception.InvalidMbtiException;
import project.mbti.util.ClientIpExtracter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.http.MediaType.APPLICATION_FORM_URLENCODED_VALUE;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @WebMvcTest 어노테이션을 사용하면 웹 레이어 테스트를 하는 데 필요한
 * @Controller, @ControllerAdvice, @JsonComponent, Converter, GenericConverter,
 * Filter, WebMvcConfigurer, HandlerMethodArgumentResolver 등만 Bean으로 등록한다.
 * <p>
 * 이 밖에 테스트를 하는 데 필요하지 않은 컴포넌트들(ex. @Service, @Repository)은 Bean으로 등록하지 않는다.
 */
@MockBean(JpaMetamodelMappingContext.class)
@WebMvcTest(value = CommentController.class)
class CommentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CommentService commentService;

    @MockBean
    private ClientIpExtracter clientIpExtracter;

    @Test
    @DisplayName("댓글 작성 API")
    void write_api() throws Exception {
        // given
        Comment comment = Comment.builder()
                .name("만두")
                .password("1234")
                .mbti(MBTI.ISTJ)
                .content("댓글")
                .parent(Optional.empty())
                .build();

        CommentWriteDto commentWriteDto = new CommentWriteDto(MBTI.ISTJ, "만두", "1234", "댓글");

        doReturn("127.0.0.1").when(clientIpExtracter).extract(any());
        doReturn(CommentWriteResultType.SUCCESS).when(commentService).create(comment.getMbti(), comment.getName(), comment.getPassword(), comment.getContent(), 0L, "127.0.0.1");

        // when
        final ResultActions perform = mockMvc.perform(
                post("/comment")
                        .contentType(APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(commentWriteDto)));

        // then
        perform
                .andExpect(status().isOk())
                .andExpect(jsonPath("code").value("C100"));
    }

    @Test
    @DisplayName("댓글 작성 API 예외1: 유효하지 않은 MBTI 입력")
    void write_api_ex1() throws Exception {
        // given
        Comment comment = Comment.builder()
                .name("만두")
                .password("1234")
                .mbti(MBTI.NOT_FOUND)
                .content("댓글")
                .parent(Optional.empty())
                .build();

        doReturn("127.0.0.1").when(clientIpExtracter).extract(any());
        CommentWriteDto commentWriteDto = new CommentWriteDto(MBTI.NOT_FOUND, "만두", "1234", "댓글");

        doThrow(new InvalidMbtiException()).when(commentService).create(comment.getMbti(), comment.getName(), comment.getPassword(), comment.getContent(), 0L, "127.0.0.1");

        // when
        final ResultActions perform = mockMvc.perform(
                post("/comment")
                        .contentType(APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(commentWriteDto)));

        // then
        perform
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("code").value("M001"));
    }

    @Test
    @DisplayName("댓글 작성 API 예외2: BindException")
    void write_api_ex2() throws Exception {
        // given
        CommentWriteDto commentWriteDto = new CommentWriteDto(null, "만두", "1234", "댓글");
        CommentWriteDto commentWriteDto2 = new CommentWriteDto(MBTI.ISTJ, "만", "1234", "댓글");
        CommentWriteDto commentWriteDto3 = new CommentWriteDto(MBTI.ISTJ, "만두", "1", "댓글");
        CommentWriteDto commentWriteDto4 = new CommentWriteDto(MBTI.ISTJ, "만두", "1234", " ");

        // when
        final ResultActions perform = mockMvc.perform(
                post("/comment")
                        .contentType(APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(commentWriteDto)));
        final ResultActions perform2 = mockMvc.perform(
                post("/comment")
                        .contentType(APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(commentWriteDto2)));
        final ResultActions perform3 = mockMvc.perform(
                post("/comment")
                        .contentType(APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(commentWriteDto3)));
        final ResultActions perform4 = mockMvc.perform(
                post("/comment")
                        .contentType(APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(commentWriteDto4)));

        // then
        perform
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("code").value("U002"));
        perform2
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("code").value("U002"));
        perform3
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("code").value("U002"));
        perform4
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("code").value("U002"));
    }

    @Test
    @DisplayName("댓글 삭제 API")
    void delete_api() throws Exception {
        // given
        Comment comment = Comment.builder()
                .name("만두")
                .password("1234")
                .mbti(MBTI.ISTJ)
                .content("댓글")
                .parent(Optional.empty())
                .build();
        comment.updateState(CommentState.DELETED);

        CommentDeleteDto dto = new CommentDeleteDto(1L, "만두", "1234");

        doReturn(comment).when(commentService).delete(any(Long.class), any(String.class), any(String.class));

        // when
        final ResultActions perform = mockMvc.perform(
                patch("/comment")
                        .contentType(APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(dto)));

        // then
        perform
                .andExpect(status().isOk())
                .andExpect(jsonPath("code").value("C101"));
    }

    @Test
    @DisplayName("댓글 삭제 API 예외1: 존재하지 않는 댓글")
    void delete_api_ex1() throws Exception {
        // given
        CommentDeleteDto dto = new CommentDeleteDto(1L, "만두", "1234");

        doThrow(new CommentNotFoundException()).when(commentService).delete(any(Long.class), any(String.class), any(String.class));

        // when
        final ResultActions perform = mockMvc.perform(
                patch("/comment")
                        .contentType(APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(dto)));

        // then
        perform
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("code").value("C001"));
    }

    @Test
    @DisplayName("댓글 삭제 API 예외2: 댓글 작성자 닉네임 불일치")
    void delete_api_ex2() throws Exception {
        // given
        CommentDeleteDto dto = new CommentDeleteDto(1L, "구름", "1234");

        doThrow(new CommentNameNotMatchException()).when(commentService).delete(any(Long.class), any(String.class), any(String.class));

        // when
        final ResultActions perform = mockMvc.perform(
                patch("/comment")
                        .contentType(APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(dto)));

        // then
        perform
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("code").value("C002"));
    }

    @Test
    @DisplayName("댓글 삭제 API 예외3: 댓글 작성자 비밀번호 불일치")
    void delete_api_ex3() throws Exception {
        // given
        CommentDeleteDto dto = new CommentDeleteDto(1L, "만두", "4321");

        doThrow(new CommentPasswordNotMatchException()).when(commentService).delete(any(Long.class), any(String.class), any(String.class));

        // when
        final ResultActions perform = mockMvc.perform(
                patch("/comment")
                        .contentType(APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(dto)));

        // then
        perform
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("code").value("C003"));
    }

    @Test
    @DisplayName("댓글 삭제 API 예외4: BindException")
    void delete_api_ex4() throws Exception {
        // given
        CommentDeleteDto CommentDeleteDto = new CommentDeleteDto(1L, "만", "1234");
        CommentDeleteDto CommentDeleteDto2 = new CommentDeleteDto(1L, "만두", " ");

        // when
        final ResultActions perform = mockMvc.perform(
                patch("/comment")
                        .contentType(APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(CommentDeleteDto)));
        final ResultActions perform2 = mockMvc.perform(
                patch("/comment")
                        .contentType(APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(CommentDeleteDto2)));

        // then
        perform
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("code").value("U002"));
        perform2
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("code").value("U002"));
    }

    @Test
    @DisplayName("댓글 페이징 조회 API")
    void commentList() throws Exception {
        // given
        int page = 1, size = 10;
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

        final Page<CommentDto> commentDtoPage = new PageImpl<>(commentDtos);

        doReturn(commentDtoPage).when(commentService).getCommentPage(page, size);

        // when
        final ResultActions perform = mockMvc.perform(
                get("/comment")
                        .contentType(APPLICATION_FORM_URLENCODED_VALUE)
                        .param("page", Integer.toString(page))
                        .param("size", Integer.toString(size)));

        // then
        perform
                .andExpect(status().isOk())
                .andExpect(jsonPath("code").value("C102"));
    }

    @Test
    @DisplayName("댓글 페이징 조회 API 예외1: ArgsTypeMissMatch Exception")
    void commentList_ex1() throws Exception {
        // given
        String validArg = "1";
        String invalidArg = "asdf";

        // when
        final ResultActions perform = mockMvc.perform(
                get("/comment")
                        .contentType(APPLICATION_FORM_URLENCODED_VALUE)
                        .param("page", invalidArg)
                        .param("size", validArg));
        final ResultActions perform2 = mockMvc.perform(
                get("/comment")
                        .contentType(APPLICATION_FORM_URLENCODED_VALUE)
                        .param("page", validArg)
                        .param("size", invalidArg));

        // then
        perform
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("code").value("U004"));
        perform2
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("code").value("U004"));

    }
}