package project.mbti.mbti;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class TestResult {

    // TODO: MBTI별 나와 같은 유형 + 가장 많은 유형 데이터 추가
    private Character character;
    private Chemistry bestChemistry;
    private Chemistry worstChemistry;
    private List<Image> recommendedMovies;
}
