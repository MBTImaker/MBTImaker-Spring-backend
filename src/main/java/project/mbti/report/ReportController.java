package project.mbti.report;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import project.mbti.report.dto.*;
import project.mbti.report.entity.ReportState;
import project.mbti.response.result.ResultCode;
import project.mbti.response.result.ResultResponse;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;

import static project.mbti.response.result.ResultCode.*;

@Api(tags = "신고 API")
@RestController
@RequiredArgsConstructor
public class ReportController {

    private final ReportService reportService;

    @ApiOperation(value = "댓글 신고")
    @PostMapping("/report")
    public ResponseEntity<ResultResponse> report(@Validated @RequestBody ReportWriteDto dto, HttpServletRequest request) {
        final String clientIp = request.getHeader("X-Forwarded-For");
        final ReportWriteResultType result = reportService.create(dto.getSubject(), dto.getDescription(), dto.getCommentId(), clientIp);
        final ReportWriteResponseDto reportResultDto = new ReportWriteResponseDto(result, clientIp);
        final ResultCode resultCode = result.equals(ReportWriteResultType.SUCCESS) ? WRITE_REPORT_SUCCESS : WRITE_REPORT_FAILURE;

        return ResponseEntity.ok()
                .body(ResultResponse.of(resultCode, reportResultDto));
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

    @ApiOperation(value = "신고 처리", notes = "처리 일자는 자동으로 처리 사유에 기재됩니다.")
    @PatchMapping("/report")
    public ResponseEntity<ResultResponse> process(@Validated @RequestBody ReportProcessDto dto) {
        final ReportDto reportDto = reportService.process(dto);

        return ResponseEntity.ok()
                .body(ResultResponse.of(PROCESS_REPORT_SUCCESS, reportDto));
    }
}
