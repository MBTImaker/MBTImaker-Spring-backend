package project.mbti.test;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.mbti.MBTI;
import project.mbti.test.dto.mbti.MbtiCharacterSmall;
import project.mbti.test.dto.mbti.MBTIResult;
import project.mbti.test.dto.mbti.Type;
import project.mbti.test.dto.TestResultDto;
import project.mbti.test.entity.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TestService {

    private final TestRepository testRepository;

    public long getCount() {
        return testRepository.count();
    }

    @Transactional
    public TestResultDto analysis(String testCode) {
        final String curMbti = analysisMbtiType(testCode);
        final List<Test> tests = testRepository.findAll();

        int maxCount = 0;
        int curMbtiCount = 0;
        String popularMbti = null;
        Map<String, Integer> counts = new HashMap<>();
        for (Test test : tests) {
            final String mbtiName = test.getMbti().name();
            final int count = counts.getOrDefault(mbtiName, 0) + 1;
            counts.put(mbtiName, count);

            if (mbtiName.equals(curMbti))
                curMbtiCount++;
            if (count > maxCount) {
                maxCount = count;
                popularMbti = mbtiName;
            }
        }

        final MbtiCharacterSmall sameCharacter = MbtiCharacterSmall.valueOf(curMbti);
        final MbtiCharacterSmall popularCharacter = MbtiCharacterSmall.valueOf(popularMbti);
        final MBTIResult mbtiResult = MBTIResult.valueOf(curMbti);

        return TestResultDto.builder()
                .mbtiResult(mbtiResult.getTestResult())
                .sameType(new Type(sameCharacter.getMovieName(), sameCharacter.getCharacterName(), sameCharacter.getImageUrl(), curMbtiCount * 100 / tests.size()))
                .mostPopularType(new Type(popularCharacter.getMovieName(), popularCharacter.getCharacterName(), popularCharacter.getImageUrl(), maxCount * 100 / tests.size()))
                .build();
    }

    private String analysisMbtiType(String testCode) {
        String value = "";
        value = (getAnInt(testCode, 0) > 1 ? value.concat("I") : value.concat("E"));
        value = (getAnInt(testCode, 4) > 1 ? value.concat("N") : value.concat("S"));
        value = (getAnInt(testCode, 8) > 1 ? value.concat("T") : value.concat("F"));
        value = (getAnInt(testCode, 12) > 1 ? value.concat("P") : value.concat("J"));
        testRepository.save(new Test(MBTI.valueOf(value)));

        return value;
    }

    private int getAnInt(String testCode, int start) {
        return Integer.parseInt(testCode.substring(start, start + 1))
                + Integer.parseInt(testCode.substring(start + 1, start + 2))
                + Integer.parseInt(testCode.substring(start + 2, start + 3));
    }
}
