package project.mbti.mbti;

import lombok.Getter;

import java.util.List;

@Getter
public enum MBTIResult {

    ISTJ(new TestResult( // TODO: null인 부분에 Image 객체 넣기
            new Character("킹스맨", "해리 하트", null, "원리원칙을 지키는 성격을 가지고 있어요.",
                    List.of("낯가림이 심한 편이에요.", "주어진 업무나 책임을 끝까지 완수해요.", "실수한 것을 참지 못해요.",
                            "참고 참았다가 터뜨리는 편이에요.", "직설적인 표현을 많이 하는 편이에요.", "사고방식이 로봇 같아서 냉정한 사람처럼 보여요.",
                            "정리정돈을 우선시해요.", "현실적, 대중적인 것들을 좋아해요.", "의젓한 성격을 가지고 있어요.",
                            "예고없는 갑작스러운 변화는 싫어요.")),
            new Chemistry(null, "수어사이드 스쿼드", "할리퀸"),
            new Chemistry(null, "신비한 동물사전", "뉴트 스캐맨더"),
            List.of() // TODO: 추천 영화 이미지 3개 추가
    ))
    ;

    private TestResult testResult;

    MBTIResult(TestResult testResult) {
        this.testResult = testResult;
    }
}
