package project.mbti;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum MBTI {
    ISTJ, ISFJ, INFJ, INTJ,
    ISTP, ISFP, INFP, INTP,
    ESTP, ESFP, ENFP, ENTP,
    ESTJ, ESFJ, ENFJ, ENTJ,
    NOT_FOUND;

    @JsonCreator
    public static MBTI getEnumFromValue(String value) {
        try {
            return MBTI.valueOf(value);
        } catch (Exception e) {
            return NOT_FOUND;
        }
    }
}
