package project.mbti.response.result;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResultCode {

    // Comment
    WRITE_COMMENT_SUCCESS(200,"C100", "댓글 작성 성공"),
    DELETE_COMMENT_SUCCESS(200,"C101", "댓글 삭제 성공"),
    FIND_COMMENT_PAGE_SUCCESS(200,"C102", "댓글 페이징 조회 성공"),
    FIND_REPLY_PAGE_SUCCESS(200,"C103", "대댓글 페이징 조회 성공"),
    WRITE_COMMENT_FAILURE(200,"C104", "댓글 작성 실패"),

    // Test
    GET_TEST_COUNT_SUCCESS(200, "T100", "테스트 참여 횟수 조회 성공"),
    ANALYSIS_TEST_SUCCESS(200, "T101", "테스트 분석 성공"),

    // Report
    WRITE_REPORT_SUCCESS(200, "R100", "댓글 신고 성공"),
    FIND_REPORT_PAGE_SUCCESS(200, "R101", "신고 페이징 조회 성공"),
    PROCESS_REPORT_SUCCESS(200, "R102", "신고 처리 성공"),
    WRITE_REPORT_FAILURE(200, "R103", "댓글 신고 실패"),

    // Block
    BLOCK_IP_SUCCESS(200, "B100", "IP 차단 성공"),
    UNBLOCK_IP_SUCCESS(200, "B101", "IP 차단 해제 성공"),
    FIND_BLOCK_PAGE_SUCCESS(200, "B102", "IP 차단목록 페이징 조회 성공"),
    ;

    private int status;
    private final String code;
    private final String message;
}