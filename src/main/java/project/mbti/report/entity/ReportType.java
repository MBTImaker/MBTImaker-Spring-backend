package project.mbti.report.entity;

/**
 * 신고 유형
 * 욕설/비방 , 음란물/불건절한 대화, 상업적 광고/판매, 도배
 * 지나친 정치/종교 논쟁, 불법홍보
 */
public enum ReportType {
    ABUSE, PORNOGRAPHY, COMMERCIAL, PAPERING,
    DISPUTE, PROMOTION;
}
