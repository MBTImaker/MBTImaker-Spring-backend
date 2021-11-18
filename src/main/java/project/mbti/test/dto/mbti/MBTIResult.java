package project.mbti.test.dto.mbti;

import lombok.Getter;
import project.mbti.MBTI;

@Getter
public enum MBTIResult {

    ISTJ(new TestResult(
            MBTI.ISTJ,
            new Character(MbtiCharacterLarge.ISTJ),
            new Chemistry(MbtiCharacterSmall.ESFP),
            new Chemistry(MbtiCharacterSmall.INFP),
            MbtiRecommendedMovies.ISTJ
    )),
    ISFJ(new TestResult(
            MBTI.ISFJ,
            new Character(MbtiCharacterLarge.ISFJ),
            new Chemistry(MbtiCharacterSmall.ESTP),
            new Chemistry(MbtiCharacterSmall.ENFP),
            MbtiRecommendedMovies.ISFJ
    )),
    ISTP(new TestResult(
            MBTI.ISTP,
            new Character(MbtiCharacterLarge.ISTP),
            new Chemistry(MbtiCharacterSmall.ISFJ),
            new Chemistry(MbtiCharacterSmall.INFJ),
            MbtiRecommendedMovies.ISTP
    )),
    ISFP(new TestResult(
            MBTI.ISFP,
            new Character(MbtiCharacterLarge.ISFP),
            new Chemistry(MbtiCharacterSmall.ENFJ),
            new Chemistry(MbtiCharacterSmall.INFP),
            MbtiRecommendedMovies.ISFP
    )),
    INTJ(new TestResult(
            MBTI.INTJ,
            new Character(MbtiCharacterLarge.INTJ),
            new Chemistry(MbtiCharacterSmall.ENFP),
            new Chemistry(MbtiCharacterSmall.ISFJ),
            MbtiRecommendedMovies.INTJ
    )),
    INTP(new TestResult(
            MBTI.INTP,
            new Character(MbtiCharacterLarge.INTP),
            new Chemistry(MbtiCharacterSmall.ENTJ),
            new Chemistry(MbtiCharacterSmall.ESFJ),
            MbtiRecommendedMovies.INTP
    )),
    INFJ(new TestResult(
            MBTI.INFJ,
            new Character(MbtiCharacterLarge.INFJ),
            new Chemistry(MbtiCharacterSmall.ENFP),
            new Chemistry(MbtiCharacterSmall.ISFP),
            MbtiRecommendedMovies.INFJ
    )),
    INFP(new TestResult(
            MBTI.INFP,
            new Character(MbtiCharacterLarge.INFP),
            new Chemistry(MbtiCharacterSmall.ENFJ),
            new Chemistry(MbtiCharacterSmall.ISFP),
            MbtiRecommendedMovies.INFP
    )),
    ESTP(new TestResult(
            MBTI.ESTP,
            new Character(MbtiCharacterLarge.ESTP),
            new Chemistry(MbtiCharacterSmall.ISTJ),
            new Chemistry(MbtiCharacterSmall.ENFP),
            MbtiRecommendedMovies.ESTP)),
    ESTJ(new TestResult(
            MBTI.ESTJ,
            new Character(MbtiCharacterLarge.ESTJ),
            new Chemistry(MbtiCharacterSmall.ISFP),
            new Chemistry(MbtiCharacterSmall.ENFP),
            MbtiRecommendedMovies.ESTJ)),
    ESFP(new TestResult(
            MBTI.ESFP,
            new Character(MbtiCharacterLarge.ESFP),
            new Chemistry(MbtiCharacterSmall.ISTJ),
            new Chemistry(MbtiCharacterSmall.ENFP),
            MbtiRecommendedMovies.ESFP)),
    ESFJ(new TestResult(
            MBTI.ESFJ,
            new Character(MbtiCharacterLarge.ESFJ),
            new Chemistry(MbtiCharacterSmall.ISFJ),
            new Chemistry(MbtiCharacterSmall.ENFP),
            MbtiRecommendedMovies.ESFJ)),
    ENTP(new TestResult(
            MBTI.ENTP,
            new Character(MbtiCharacterLarge.ENTP),
            new Chemistry(MbtiCharacterSmall.INFJ),
            new Chemistry(MbtiCharacterSmall.ESTJ),
            MbtiRecommendedMovies.ENTP)),
    ENTJ(new TestResult(
            MBTI.ENTJ,
            new Character(MbtiCharacterLarge.ENTJ),
            new Chemistry(MbtiCharacterSmall.INTP),
            new Chemistry(MbtiCharacterSmall.ESTJ),
            MbtiRecommendedMovies.ENTJ)),
    ENFP(new TestResult(
            MBTI.ENFP,
            new Character(MbtiCharacterLarge.ENFP),
            new Chemistry(MbtiCharacterSmall.INTJ),
            new Chemistry(MbtiCharacterSmall.ISTJ),
            MbtiRecommendedMovies.ENFP)),
    ENFJ(new TestResult(
            MBTI.ENFJ,
            new Character(MbtiCharacterLarge.ENFJ),
            new Chemistry(MbtiCharacterSmall.ISFP),
            new Chemistry(MbtiCharacterSmall.ESTP),
            MbtiRecommendedMovies.ENFJ)),
    ;

    private final TestResult testResult;

    MBTIResult(TestResult testResult) {
        this.testResult = testResult;
    }
}
