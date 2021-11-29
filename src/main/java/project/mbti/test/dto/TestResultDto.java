package project.mbti.test.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import project.mbti.test.dto.mbti.TestResult;
import project.mbti.test.dto.mbti.Type;

@Getter
@Builder
@AllArgsConstructor
public class TestResultDto {

    private final TestResult mbtiResult;
    private final Type sameType;
    private final Type mostPopularType;
    private final String KAKAO_JAVASCRIPT_KEY = "5b31acb4c361a42e64bc467dba869278";
}
