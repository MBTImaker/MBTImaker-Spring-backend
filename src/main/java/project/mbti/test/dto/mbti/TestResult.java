package project.mbti.test.dto.mbti;

import lombok.Getter;
import project.mbti.MBTI;

import java.util.List;

@Getter
public class TestResult {

    private final MBTI mbti;
    private final Character character;
    private final Chemistry bestChemistry;
    private final Chemistry worstChemistry;
    private final List<Image> recommendedMovies;

    public TestResult(MBTI mbti, Character character, Chemistry bestChemistry, Chemistry worstChemistry, MbtiRecommendedMovies MbtiRecommendedMovies) {
        this.mbti = mbti;
        this.character = character;
        this.bestChemistry = bestChemistry;
        this.worstChemistry = worstChemistry;
        this.recommendedMovies = MbtiRecommendedMovies.getImages();
    }
}
