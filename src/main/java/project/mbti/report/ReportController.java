package project.mbti.report;

import static project.mbti.response.result.ResultCode.REPORT_SUCCESS;
import static project.mbti.response.result.ResultCode.WRITE_SUCCESS;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import project.mbti.report.dto.ReportAddDto;
import project.mbti.report.dto.ReportDto;
import project.mbti.report.dto.ReportUpdateDto;
import project.mbti.report.entity.Report;
import project.mbti.report.entity.ReportState;
import project.mbti.response.result.ResultResponse;

@Api(tags = "신고 API")
@RestController
@RequiredArgsConstructor
public class ReportController {

    private final ReportService reportService;

    @ApiOperation(value = "신고 전체 목록")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "페이지", example = "1", required = true),
        @ApiImplicitParam(name = "size", value = "한 페이지 신고 갯수", example = "5", required = true),
    })
    @GetMapping("/report")
    public ResponseEntity<ResultResponse> getAll(int page, int size){
        Page<Report> reports = reportService.findAll(page, size);
        return ResponseEntity.ok().body(ResultResponse.of(REPORT_SUCCESS, reports));
    }

    @ApiOperation(value = "신고 생성")
    @PostMapping("/report")
    public ResponseEntity<ResultResponse> create(@RequestBody ReportAddDto reportAddDto) {
        final Report report = reportService.create(reportAddDto);
        final ReportDto reportDto = report.create();

        RestTemplate restTemplate = new RestTemplate();
        Map<String, Object> request = new HashMap<>();
        HttpEntity<Map<String, Object>> entity = new HttpEntity<Map<String, Object>>(request);

        // Slack Message
        request.put("username", "Report Alarm"); //slack bot name
        request.put("text", "신고 댓글 번호 : " + reportDto.getId() + "\n 신고 댓글 내용 : " + report.getComment().getContent() ); //전송할 메세지

        //Webhook URL
        String url = "https://hooks.slack.com/services/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";
        restTemplate.exchange(url, HttpMethod.POST, entity, String.class);

        return ResponseEntity.ok().body(ResultResponse.of(REPORT_SUCCESS, reportDto));
    }

    @ApiOperation(value = "신고 상태 업데이트")
    @PostMapping("/report/update")
    public ResponseEntity<ResultResponse> update(@RequestBody ReportUpdateDto reportUpdateDto) {
        final Report report = reportService.update(reportUpdateDto);
        final ReportDto reportDto = report.create();
        return ResponseEntity.ok().body(ResultResponse.of(REPORT_SUCCESS, reportDto));
    }

}