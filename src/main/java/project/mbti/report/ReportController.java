package project.mbti.report;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import project.mbti.report.dto.ReportDto;
import project.mbti.report.dto.ReportProcessDto;
import project.mbti.report.entity.ReportState;
import project.mbti.response.result.ResultResponse;
import project.mbti.report.dto.ReportSlackDto;
import project.mbti.report.dto.ReportWriteDto;

import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.HttpMethod.POST;
import static project.mbti.response.result.ResultCode.*;

@Api(tags = "신고 API")
@RestController
@RequiredArgsConstructor
public class ReportController {

    // TODO: 댓글 신고 처리 시, 해당 댓글 달은 ip 차단하는 방식?
    //  HttpServletRequest.getRemoteAddr() -> DB에 추가하는 방식 (신고 당한 ip나 신고 악용하는 유저 차단)
    @Value("${webhook.slack.url}")
    private String url;

    private final ReportService reportService;

    @ApiOperation(value = "댓글 신고")
    @PostMapping("/report")
    public ResponseEntity<ResultResponse> report(@Validated @RequestBody ReportWriteDto dto) {
        final ReportSlackDto reportSlackDto = reportService.create(dto);

        RestTemplate restTemplate = new RestTemplate();
        Map<String, Object> request = new HashMap<>();
        request.put("text",
                "🔥🔥🔥🔥🔥  새로운 신고가 접수되었어요!  🔥🔥🔥🔥🔥\n\n" +
                "#️⃣ 신고 id: " + reportSlackDto.getReportId() + "\n" +
                "✅ 신고 유형: " + reportSlackDto.getSubject().getName() + "\n" +
                "😫 신고 사유: " + reportSlackDto.getDescription() + "\n\n" +
                "#️⃣ 댓글 id: " + reportSlackDto.getCommentId() + "\n" +
                "🤬 댓글 내용: " + reportSlackDto.getCommentContent());

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(request);
        restTemplate.exchange(url, POST, entity, String.class);

        return ResponseEntity.ok()
                .body(ResultResponse.of(WRITE_REPORT_SUCCESS, reportSlackDto));
    }

    @ApiOperation(value = "신고 페이징 조회")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "페이지", example = "1", required = true),
            @ApiImplicitParam(name = "size", value = "신고 개수", example = "5", required = true),
    })
    @GetMapping("/report")
    public ResponseEntity<ResultResponse> reportList(@Validated @NotNull(message = "페이지를 입력해주세요.") @RequestParam int page,
                                                     @Validated @NotNull(message = "신고 개수를 입력해주세요.") @RequestParam int size,
                                                     @Validated @NotNull(message = "신고 상태를 입력해주세요.") @RequestParam ReportState state) {
        final Page<ReportDto> reportPage = reportService.getReportPage(page, size, state);

        return ResponseEntity.ok()
                .body(ResultResponse.of(FIND_REPORT_PAGE_SUCCESS, reportPage));
    }

    @ApiOperation(value = "신고 처리")
    @PatchMapping("/report")
    public ResponseEntity<ResultResponse> process(@Validated @RequestBody ReportProcessDto dto) {
        final ReportDto reportDto = reportService.process(dto);

        return ResponseEntity.ok()
                .body(ResultResponse.of(PROCESS_REPORT_SUCCESS, reportDto));
    }
}
