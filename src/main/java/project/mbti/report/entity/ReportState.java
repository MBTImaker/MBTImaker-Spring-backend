package project.mbti.report.entity;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum ReportState {
    REPORTED, COMPLETED, CANCELED,
    NOT_FOUND;

    @JsonCreator
    public static ReportState getEnumFromValue(String value) {
        try {
            return ReportState.valueOf(value);
        } catch (Exception e) {
            return NOT_FOUND;
        }
    }
}
