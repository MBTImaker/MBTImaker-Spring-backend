package project.mbti.comment;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.filter.CharacterEncodingFilter;
import project.mbti.comment.dto.CommentWriteDto;
import project.mbti.comment.entity.MBTI;

import java.nio.charset.StandardCharsets;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Transactional
@DisplayName("댓글_API_테스트")
@SpringBootTest
class CommentControllerTest {

    @Autowired
    CommentController commentController;

    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @BeforeEach
    void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(commentController)
                .addFilter(new CharacterEncodingFilter(StandardCharsets.UTF_8.name(), true))
                .alwaysDo(print())
                .build();
    }

    @Test
    @DisplayName("댓글_작성")
    void write() throws Exception {
        // given
        String commentWriteDto = objectMapper.writeValueAsString(new CommentWriteDto(MBTI.ISTJ, "만두", "1234", "우와 신기해요!"));

        // when
        mockMvc.perform(post("/comment")
                .contentType(APPLICATION_JSON)
                .content(commentWriteDto))

        // then
                .andExpect(status().is2xxSuccessful())
                .andDo(print());
    }
}