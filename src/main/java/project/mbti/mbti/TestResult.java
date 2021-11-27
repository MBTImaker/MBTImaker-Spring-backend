package project.mbti.mbti;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class TestResult {

    private Character character;
    private Chemistry bestChemistry;
    private Chemistry worstChemistry;
    private List<Image> recommendedMovies;
}
