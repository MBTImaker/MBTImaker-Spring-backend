package project.mbti.report.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

@Getter
public enum ReportSubject {
    ABUSE("욕설/비하"),
    PORNOGRAPHY("음란물/불건전한 대화"),
    COMMERCIAL("상업적 광고/판매"),
    PAPERING("낚시/도배"),
    DISPUTE("지나친 정치/종교 논쟁"),
    PROMOTION("불법 홍보"),
    NOT_FOUND("");

    @JsonCreator
    public static ReportSubject getEnumFromValue(String value) {
        try {
            return ReportSubject.valueOf(value);
        } catch (Exception e) {
            return NOT_FOUND;
        }
    }

    private final String name;

    ReportSubject(String name) {
        this.name = name;
    }
}
