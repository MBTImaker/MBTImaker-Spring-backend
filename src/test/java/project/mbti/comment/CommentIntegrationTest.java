package project.mbti.comment;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.transaction.annotation.Transactional;
import project.mbti.MBTI;
import project.mbti.comment.dto.*;
import project.mbti.comment.entity.CommentState;
import project.mbti.response.error.ErrorResponse;
import project.mbti.response.result.ResultResponse;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
public class CommentIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    final String url = "/comment";

    /**
     * {@code ObjectMapper.convertValue()}
     * @Reference https://stackoverflow.com/questions/15430715/casting-linkedhashmap-to-complex-object
     */
    @Test
    @DisplayName("댓글 작성 API")
    void write_api() throws Exception {
        // given
        final CommentWriteDto dto = new CommentWriteDto(MBTI.ISTJ, "만두", "1234", "댓글");
        final HttpEntity<CommentWriteDto> request = new HttpEntity<>(dto);

        // when
        ResponseEntity<ResultResponse> response = restTemplate.postForEntity(url, request, ResultResponse.class);
        final CommentWriteResponseDto commentWriteResponseDto = objectMapper.convertValue(response.getBody().getData(), CommentWriteResponseDto.class);

        // then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody().getCode()).isEqualTo("C100");
        assertThat(commentWriteResponseDto.getResult()).isEqualTo(CommentWriteResultType.SUCCESS);
    }

    @Test
    @DisplayName("댓글 작성 API 예외1: 유효하지 않은 MBTI 입력")
    void write_api_ex1() throws Exception {
        // given
        final CommentWriteDto dto = new CommentWriteDto(MBTI.NOT_FOUND, "만두", "1234", "댓글");
        final HttpEntity<CommentWriteDto> request = new HttpEntity<>(dto);

        // when
        ResponseEntity<ErrorResponse> response = restTemplate.postForEntity(url, request, ErrorResponse.class);

        // then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
        assertThat(response.getBody().getCode()).isEqualTo("M001");
    }

    @Test
    @DisplayName("댓글 작성 API 예외2: BindException")
    void write_api_ex2() throws Exception {
        // given
        final CommentWriteDto dto = new CommentWriteDto(MBTI.ISTJ, "만", "", "  ");
        final HttpEntity<CommentWriteDto> request = new HttpEntity<>(dto);

        // when
        ResponseEntity<ErrorResponse> response = restTemplate.postForEntity(url, request, ErrorResponse.class);

        // then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
        assertThat(response.getBody().getCode()).isEqualTo("U002");
        assertThat(response.getBody().getErrors().size()).isEqualTo(3);
    }

    void init() {
        final CommentWriteDto dto = new CommentWriteDto(MBTI.ISTJ, "만두", "1234", "댓글");
        final HttpEntity<CommentWriteDto> request = new HttpEntity<>(dto);
        restTemplate.postForEntity(url, request, ResultResponse.class);
    }

    /**
     * {@code RestTemplate PATCH 지원X 해결 방법}
     * @Reference https://blog.voidmainvoid.net/224
     */
    @Test
    @DisplayName("댓글 삭제 API")
    void delete_api() throws Exception {
        // given
        init();
        final CommentDeleteDto dto = new CommentDeleteDto(1L, "만두", "1234");
        final HttpEntity<CommentDeleteDto> request = new HttpEntity<>(dto);

        // when
        final ResponseEntity<ResultResponse> response = restTemplate.exchange(url, HttpMethod.PATCH, request, ResultResponse.class);
        final CommentDto commentDto = objectMapper.convertValue(response.getBody().getData(), CommentDto.class);

        // then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody().getCode()).isEqualTo("C101");
        assertThat(commentDto.getState()).isEqualTo(CommentState.DELETED);
    }

    @Test
    @DisplayName("댓글 삭제 API 예외1: 존재하지 않는 댓글 삭제")
    void delete_api_ex1() throws Exception {
        // given
        final CommentDeleteDto dto = new CommentDeleteDto(3L, "만두", "1234");
        final HttpEntity<CommentDeleteDto> request = new HttpEntity<>(dto);

        // when
        final ResponseEntity<ErrorResponse> response = restTemplate.exchange(url, HttpMethod.PATCH, request, ErrorResponse.class);

        // then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
        assertThat(response.getBody().getCode()).isEqualTo("C001");
    }

    @Test
    @DisplayName("댓글 삭제 API 예외2: 댓글 작성자 정보 불일치")
    void delete_api_ex2() throws Exception {
        // given
        init();
        final CommentDeleteDto dto = new CommentDeleteDto(1L, "구름", "1234");
        final HttpEntity<CommentDeleteDto> request = new HttpEntity<>(dto);
        final CommentDeleteDto dto2 = new CommentDeleteDto(1L, "만두", "4321");
        final HttpEntity<CommentDeleteDto> request2 = new HttpEntity<>(dto2);

        // when
        final ResponseEntity<ErrorResponse> response = restTemplate.exchange(url, HttpMethod.PATCH, request, ErrorResponse.class);
        final ResponseEntity<ErrorResponse> response2 = restTemplate.exchange(url, HttpMethod.PATCH, request2, ErrorResponse.class);

        // then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
        assertThat(response2.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
        assertThat(response.getBody().getCode()).isEqualTo("C002");
        assertThat(response2.getBody().getCode()).isEqualTo("C003");
    }

    @Test
    @DisplayName("댓글 삭제 API 예외3: BindException")
    void delete_api_ex3() throws Exception {
        // given
        final CommentDeleteDto dto = new CommentDeleteDto(null, " ", " ");
        final HttpEntity<CommentDeleteDto> request = new HttpEntity<>(dto);

        // when
        final ResponseEntity<ErrorResponse> response = restTemplate.exchange(url, HttpMethod.PATCH, request, ErrorResponse.class);

        // then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
        assertThat(response.getBody().getCode()).isEqualTo("U002");
        assertThat(response.getBody().getErrors().size()).isEqualTo(4);
    }
}
