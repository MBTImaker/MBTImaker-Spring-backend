package project.mbti.test;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import project.mbti.response.result.ResultResponse;
import project.mbti.test.dto.TestCodeDto;
import project.mbti.test.dto.TestCountDto;
import project.mbti.test.dto.TestResultDto;

import static project.mbti.response.result.ResultCode.*;

@Api(tags = "테스트 API")
@RestController
@RequiredArgsConstructor
public class TestController {

    private final TestService testService;

    @ApiOperation(value = "테스트 참여 횟수 조회")
    @GetMapping("/test")
    public ResponseEntity<ResultResponse> count() {
        final long count = testService.getCount();
        final TestCountDto response = new TestCountDto(count);

        return ResponseEntity.ok(ResultResponse.of(GET_TEST_COUNT_SUCCESS, response));
    }

    @ApiOperation(value = "테스트 결과 분석")
    @PostMapping("/test")
    public ResponseEntity<ResultResponse> analysis(@Validated @RequestBody TestCodeDto request) {
        final TestResultDto response = testService.analysis(request.getTestCode());

        return ResponseEntity.ok(ResultResponse.of(ANALYSIS_TEST_SUCCESS, response));
    }
}
