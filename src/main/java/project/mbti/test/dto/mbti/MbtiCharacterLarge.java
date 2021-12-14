package project.mbti.test.dto.mbti;

import lombok.Getter;

import java.util.List;

@Getter
public enum MbtiCharacterLarge {

    ISTJ(
            new Image("https://mbti-image-server.s3.ap-northeast-2.amazonaws.com/movie-title/movie-title/title_ISTJ_%ED%82%B9%EC%8A%A4%EB%A7%A8.png"),
            new Image("https://mbti-image-server.s3.ap-northeast-2.amazonaws.com/movie-character/movie-character/character_ISTJ_%ED%95%B4%EB%A6%AC%ED%95%98%ED%8A%B8.png"),
            new Image("https://mbti-image-server.s3.ap-northeast-2.amazonaws.com/character-Big-Image/character-Big-Image/big_ISTJ_%ED%82%B9%EC%8A%A4%EB%A7%A8_%ED%95%B4%EB%A6%AC+%ED%95%98%ED%8A%B8.png"),
            "원리원칙을 지키는<br>성격을 가지고 있어요.",
            List.of("낯가림이 심한 편이에요.", "주어진 업무나 책임을 끝까지 완수해요.", "실수한 것을 참지 못해요.",
                    "참고 참았다가 터뜨리는 편이에요.", "직설적인 표현을 많이 하는 편이에요.", "사고방식이 로봇 같아서 냉정한 사람처럼 보여요.",
                    "정리정돈을 우선시해요.", "현실적, 대중적인 것들을 좋아해요.", "의젓한 성격을 가지고 있어요.",
                    "예고없는 갑작스러운 변화는 싫어요.")),
    ISTP(
            new Image("https://mbti-image-server.s3.ap-northeast-2.amazonaws.com/movie-title/movie-title/title_ISTP_007.png"),
            new Image("https://mbti-image-server.s3.ap-northeast-2.amazonaws.com/movie-character/movie-character/character_ISTP_%EC%A0%9C%EC%9E%84%EC%8A%A4%EB%B3%B8%EB%93%9C.png"),
            new Image("https://mbti-image-server.s3.ap-northeast-2.amazonaws.com/character-Big-Image/character-Big-Image/big_ISTP_007_%EC%A0%9C%EC%9E%84%EC%8A%A4+%EB%B3%B8%EB%93%9C.png"),
            "솔직하고 섬세한<br>성격을 가지고 있어요.",
            List.of("눈치가 빠른 편이에요.", "약속을 중요하게 여겨요.", "체계적이에요.",
                    "공감 능력이 뛰어나요.", "솔직하고 섬세해요.", "쓸모없는 낭비를 싫어해요.",
                    "생각이 많은 편이에요.", "인간관계에서 스트레스를 많이 받아요.", "성격이 온화한 편이에요.",
                    "계획 세우는 걸 좋아해요.")),
    ISFP(
            new Image("https://mbti-image-server.s3.ap-northeast-2.amazonaws.com/movie-title/movie-title/title_ISFP_%ED%83%80%EC%9D%B4%ED%83%80%EB%8B%89.png"),
            new Image("https://mbti-image-server.s3.ap-northeast-2.amazonaws.com/movie-character/movie-character/character_ISFP_%EB%A1%9C%EC%A6%88.png"),
            new Image("https://mbti-image-server.s3.ap-northeast-2.amazonaws.com/character-Big-Image/character-Big-Image/big_ISFP_%ED%83%80%EC%9D%B4%ED%83%80%EB%8B%89_%EB%A1%9C%EC%A6%88.png"),
            "논리적인<br>성격을 가지고 있어요.",
            List.of("조용하고 과묵해요.", "객관적인 편이에요.", "상황을 파악하는 능력이 있어요.",
                    "감정 표현하기를 어려워해요.", "순간 집중력이 좋아요.", "분석 능력, 관찰력이 좋아요.",
                    "귀찮아하는 게 많아요.", "공감능력이 다소 부족해요.", "혼자 시간을 보내는 걸 좋아해요.",
                    "사람과 관계 맺는 걸 어려워해요.")),
    ISFJ(
            new Image("https://mbti-image-server.s3.ap-northeast-2.amazonaws.com/movie-title/movie-title/title_ISFJ_%EC%85%9C%EB%A1%9D%ED%99%88%EC%A6%88.png"),
            new Image("https://mbti-image-server.s3.ap-northeast-2.amazonaws.com/movie-character/movie-character/character_ISFJ_%EC%99%93%EC%8A%A8.png"),
            new Image("https://mbti-image-server.s3.ap-northeast-2.amazonaws.com/character-Big-Image/character-Big-Image/big_ISFJ_%EC%85%9C%EB%A1%9D%ED%99%88%EC%A6%88_%EC%99%93%EC%8A%A8.png"),
            "이해력이 깊은<br>성격을 가지고 있어요.",
            List.of("사는 데 있어서 즐거움을 추구해요.", "다른 사람의 부탁을 거절하기 힘들어요.", "마음이 순하고 정이 많아요.",
                    "사람을 잘 의심하지 않아요.", "겸손한 편이에요.", "규칙에 얽매이지 않아요.",
                    "집착하는 것을 극도로 싫어해요.", "결단력이 다소 부족해요.", "남 눈치를 보는 편이에요.",
                    "예술적인 감각이 있어요.")),
    INTP(
            new Image("https://mbti-image-server.s3.ap-northeast-2.amazonaws.com/movie-title/movie-title/title_INTP_%EC%9D%B4%EB%AF%B8%ED%85%8C%EC%9D%B4%EC%85%98%EA%B2%8C%EC%9E%84.png"),
            new Image("https://mbti-image-server.s3.ap-northeast-2.amazonaws.com/movie-character/movie-character/character_INTP_%EC%95%A8%EB%9F%B0%ED%8A%9C%EB%A7%81.png"),
            new Image("https://mbti-image-server.s3.ap-northeast-2.amazonaws.com/character-Big-Image/character-Big-Image/big_INTP_%EC%9D%B4%EB%AF%B8%ED%85%8C%EC%9D%B4%EC%85%98+%EA%B2%8C%EC%9E%84_%EC%95%A8%EB%9F%B0+%ED%8A%9C%EB%A7%81.png"),
            "침착한<br>성격을 가지고 있어요.",
            List.of("논리적이고 객관적이에요.", "일관성있는 걸 좋아해요.", "합리적이며 공정성을 중시해요.",
                    "생각이 많은 편이에요.", "말하기 전에 여러 생각을 거치는 편이에요.", "하고자하는 것이 있으면 하는 편이에요.",
                    "플랜 B를 항상 생각해두는 편이에요.", "인간관계가 좁고 깊은 편이에요.", "통제력이 강한 편이에요.",
                    "목표 지향적이에요.")),
    INTJ(
            new Image("https://mbti-image-server.s3.ap-northeast-2.amazonaws.com/movie-title/movie-title/title_INTJ_%EB%8B%A5%ED%84%B0%EC%8A%A4%ED%8A%B8%EB%A0%88%EC%9D%B8%EC%A7%80.png"),
            new Image("https://mbti-image-server.s3.ap-northeast-2.amazonaws.com/movie-character/movie-character/character_INTJ_%EB%8B%A5%ED%84%B0%EC%8A%A4%ED%8A%B8%EB%A0%88%EC%9D%B8%EC%A7%80.png"),
            new Image("https://mbti-image-server.s3.ap-northeast-2.amazonaws.com/character-Big-Image/character-Big-Image/big_INTJ_%EB%8B%A5%ED%84%B0+%EC%8A%A4%ED%8A%B8%EB%A0%88%EC%9D%B8%EC%A7%80_%EB%8B%A5%ED%84%B0+%EC%8A%A4%ED%8A%B8%EB%A0%88%EC%9D%B8%EC%A7%80.png"),
            "정직한<br>성격을 가지고 있어요.",
            List.of("다방면으로 관심이 많아요.", "자신만의 세계가 뚜렷해요.", "혼자만의 시간이 매우 중요해요.",
                    "반항심이 강한 편이에요.", "관심사에 한 번 꽂히면 헤어나오지 못해요.", "계획보다는 즉흥이 좋아요.",
                    "공상을 자주 하는 편이에요.", "분석 또는 추리를 좋아해요.", "지식에 대한 욕심이 많아요.",
                    "감수성이 풍부해요.")),
    INFP(
            new Image("https://mbti-image-server.s3.ap-northeast-2.amazonaws.com/movie-title/movie-title/title_INFP_%EC%8B%A0%EB%B9%84%ED%95%9C%EB%8F%99%EB%AC%BC%EC%82%AC%EC%A0%84.png"),
            new Image("https://mbti-image-server.s3.ap-northeast-2.amazonaws.com/movie-character/movie-character/character_INFP_%EB%89%B4%ED%8A%B8+%EC%8A%A4%EC%BA%90%EB%A7%A8%EB%8D%94.png"),
            new Image("https://mbti-image-server.s3.ap-northeast-2.amazonaws.com/character-Big-Image/character-Big-Image/big_INFP_%EC%8B%A0%EB%B9%84%ED%95%9C+%EB%8F%99%EB%AC%BC%EC%82%AC%EC%A0%84_+%EB%89%B4%ED%8A%B8+%EC%8A%A4%EC%BA%90%EB%A7%A8%EB%8D%94.png"),
            "감수성이 풍부한<br>성격을 가지고 있어요.",
            List.of("직관력과 관찰력이 뛰어나요.", "공감 능력이 뛰어나요.", "다소 내성적이에요.",
                    "호불호가 분명하게 나뉘어요.", "상상력과 창의력이 뛰어나요.", "계획적인 것을 좋아해요.",
                    "인내심이 많은 편이에요.", "분쟁과 다툼을 싫어해요.", "호기심이 많아요.",
                    "번아웃에 취약해요.")),
    INFJ(
            new Image("https://mbti-image-server.s3.ap-northeast-2.amazonaws.com/movie-title/movie-title/title_INFJ_%EC%9C%84%EB%8C%80%ED%95%9C+%EA%B0%9C%EC%B8%A0%EB%B9%84.png"),
            new Image("https://mbti-image-server.s3.ap-northeast-2.amazonaws.com/movie-character/movie-character/character_INFJ_%EA%B0%9C%EC%B8%A0%EB%B9%84.png"),
            new Image("https://mbti-image-server.s3.ap-northeast-2.amazonaws.com/character-Big-Image/character-Big-Image/big_INFJ_%EC%9C%84%EB%8C%80%ED%95%9C+%EA%B0%9C%EC%B8%A0%EB%B9%84_%EA%B0%9C%EC%B8%A0%EB%B9%84.png"),
            "침착하고 디테일한<br>성격을 가지고 있어요.",
            List.of("성격이 세심하고 디테일해요.", "자기 자신에 대한 애정이 강해요.", "가식적인 것을 싫어해요.",
                    "본인의 영역 침범을 매우 싫어해요.", "몽상가적인 면이 있어요.", "스스로에 대해 깊은 고찰을 하는 편이에요.",
                    "스스로에 대한 평가가 박한 편이에요.", "창의성이 좋아요.", "개인적인 생각을 잘 털어놓지 않아요.",
                    "화를 잘 표출하지 않아요.")),
    ESTJ(
            new Image("https://mbti-image-server.s3.ap-northeast-2.amazonaws.com/movie-title/movie-title/title_ESTJ_%ED%95%B4%EB%A6%AC%ED%8F%AC%ED%84%B0.png"),
            new Image("https://mbti-image-server.s3.ap-northeast-2.amazonaws.com/movie-character/movie-character/character_ESTJ_%ED%97%A4%EB%A5%B4%EB%AF%B8%EC%98%A8%EB%8A%90.png"),
            new Image("https://mbti-image-server.s3.ap-northeast-2.amazonaws.com/character-Big-Image/character-Big-Image/big_ESTJ_%ED%95%B4%EB%A6%AC%ED%8F%AC%ED%84%B0_%ED%97%A4%EB%A5%B4%EB%AF%B8%EC%98%A8%EB%8A%90.png"),
            "완벽함을 추구하는<br>성격을 가지고 있어요.",
            List.of("헌신적이고 책임감이 강해요.", "계획적인 것을 선호해요.", "직설적으로 감정을 표현해요.",
                    "공감 능력이 다소 부족해요.", "고집이 강해요.", "논리적이며, 객관성이 뛰어나요.",
                    "호불호가 확실해요.", "도전정신이 강해요.", "여유보다는 바쁜 게 좋아요.",
                    "자기 관리를 잘하는 편이에요.")),
    ESFP(
            new Image("https://mbti-image-server.s3.ap-northeast-2.amazonaws.com/movie-title/movie-title/title_ESFP_%EC%88%98%EC%96%B4%EC%82%AC%EC%9D%B4%EB%93%9C.png"),
            new Image("https://mbti-image-server.s3.ap-northeast-2.amazonaws.com/movie-character/movie-character/character_ESFP_%ED%95%A0%EB%A6%AC%ED%80%B8.png"),
            new Image("https://mbti-image-server.s3.ap-northeast-2.amazonaws.com/character-Big-Image/character-Big-Image/big_ESFP_%EC%88%98%EC%96%B4%EC%82%AC%EC%9D%B4%EB%93%9C+%EC%8A%A4%EC%BF%BC%EB%93%9C_%ED%95%A0%EB%A6%AC%ED%80%B8.png"),
            "에너지가 넘치는<br>성격을 가지고 있어요.",
            List.of("즐거움을 추구해요.", "자유로운 것을 좋아해요.", "귀가 얇은 편이에요.",
                    "틀에 박힌 것을 싫어해요.", "개성적인 매력이 있어요.", "대담하고 추진력이 있어요.",
                    "새로운 것을 추구해요.", "예술적 감각이 뛰어나요.", "인간관계가 넓은 편이에요.",
                    "하고싶은 말은 많은데 정작 다 하지는 못해요.")),
    ESTP(
            new Image("https://mbti-image-server.s3.ap-northeast-2.amazonaws.com/movie-title/movie-title/title_ESTP_%EB%9D%BC%ED%91%BC%EC%A0%A4.png"),
            new Image("https://mbti-image-server.s3.ap-northeast-2.amazonaws.com/movie-character/movie-character/character_ESTP_%ED%94%8C%EB%A6%B0%EB%9D%BC%EC%9D%B4%EB%8D%94.png"),
            new Image("https://mbti-image-server.s3.ap-northeast-2.amazonaws.com/character-Big-Image/character-Big-Image/big_ESTP_%EB%9D%BC%ED%91%BC%EC%A0%A4_%ED%94%8C%EB%A6%B0+%EB%9D%BC%EC%9D%B4%EB%8D%94.png"),
            "자신감이 넘치는<br>성격을 가지고 있어요.",
            List.of("삶을 즐기면서 살고 싶어해요.", "내기를 좋아해요.", "책보다는 직접적인 경험이 좋아요.",
                    "자유롭게 일 하는게 좋아요.", "제멋대로인 경우가 가끔 있어요.", "자신감이 항상 넘쳐요.",
                    "자극적인 것을 좋아해요.", "성취욕이 강해요.", "손재주가 뛰어나요.",
                    "새로운 것에 도전 욕구가 강해요.")),
    ESFJ(
            new Image("https://mbti-image-server.s3.ap-northeast-2.amazonaws.com/movie-title/movie-title/title_ESFJ_%EB%B6%84%EB%85%B8%EC%9D%98%EC%A7%88%EC%A3%BC.png"),
            new Image("https://mbti-image-server.s3.ap-northeast-2.amazonaws.com/movie-character/movie-character/character_ESFJ_%EB%8F%94.png"),
            new Image("https://mbti-image-server.s3.ap-northeast-2.amazonaws.com/character-Big-Image/character-Big-Image/big_ESFJ_%EB%B6%84%EB%85%B8%EC%9D%98+%EC%A7%88%EC%A3%BC_%EB%8F%94.png"),
            "남을 배려하는<br>성격을 가지고 있어요.",
            List.of("변화를 싫어하는 편이에요.", "준비성이 철저해요.", "조화와 균형을 중요시해요.",
                    "싫은 소리를 하지 못해요.", "중재자 역할을 잘해요.", "리액션이 좋은 편이에요.",
                    "예의없는 사람을 굉장히 싫어해요.", "남들 챙기는 걸 좋아해요.", "자기주장이 강하진 않아요.",
                    "눈치가 굉장히 빠른 편이에요.")),
    ENTP(
            new Image("https://mbti-image-server.s3.ap-northeast-2.amazonaws.com/movie-title/movie-title/title_ENTP_%ED%81%AC%EB%A6%AC%EC%8A%A4%EB%A7%88%EC%8A%A4%EC%95%85%EB%AA%BD.png"),
            new Image("https://mbti-image-server.s3.ap-northeast-2.amazonaws.com/movie-character/movie-character/character_ENTP_%EC%9E%AD%EC%8A%A4%EC%BC%88%EB%A0%88%ED%86%A4.png"),
            new Image("https://mbti-image-server.s3.ap-northeast-2.amazonaws.com/character-Big-Image/character-Big-Image/big_ENTP_%ED%81%AC%EB%A6%AC%EC%8A%A4%EB%A7%88%EC%8A%A4%EC%9D%98+%EC%95%85%EB%AA%BD_%EC%9E%AD+%EC%8A%A4%EC%BC%88%EB%A0%88%ED%86%A4.png"),
            "통찰력이 뛰어난<br>성격을 가지고 있어요.",
            List.of("두뇌 회전이 빠른 편이에요.", "자존감이 높은 편이에요.", "타인을 편견 없이 바라보려고 해요.",
                    "가치관이나 주관이 뚜렷해요.", "토론이나 논쟁을 좋아해요.", "사람에 대한 호불호가 확실해요.",
                    "개인주의 성향이 강해요.", "모험심이 강해요.", "뒤끝이 없는 편이에요.",
                    "경쟁심이 강해요.")),
    ENTJ(
            new Image("https://mbti-image-server.s3.ap-northeast-2.amazonaws.com/movie-title/movie-title/title_ENTJ_%EC%95%85%EB%A7%88%EB%8A%94+%ED%94%84%EB%9D%BC%EB%8B%A4%EB%A5%BC+%EC%9E%85%EB%8A%94%EB%8B%A4.png"),
            new Image("https://mbti-image-server.s3.ap-northeast-2.amazonaws.com/movie-character/movie-character/character_ENTJ_%EB%AF%B8%EB%9E%80%EB%8B%A4.png"),
            new Image("https://mbti-image-server.s3.ap-northeast-2.amazonaws.com/character-Big-Image/character-Big-Image/big_ENTJ_%EC%95%85%EB%A7%88%EB%8A%94+%ED%94%84%EB%9D%BC%EB%8B%A4%EB%A5%BC+%EC%9E%85%EB%8A%94%EB%8B%A4_%EB%AF%B8%EB%9E%80%EB%8B%A4.png"),
            "통솔력 있는<br>성격을 가지고 있어요.",
            List.of("조직적, 체계적이에요.", "완벽을 추구해요.", "상상을 많이 하는 편이에요.",
                    "호기심이 많아요.", "지적 욕구가 강해요.", "감정표현이 솔직한 편이에요.",
                    "가끔 엉뚱할 때가 있어요.", "지적 능력 향상에 노력하는 편이에요.", "자기 주관이 확고해요.",
                    "미래에 대한 꿈이 큰 편이에요.")),
    ENFP(
            new Image("https://mbti-image-server.s3.ap-northeast-2.amazonaws.com/movie-title/movie-title/title_ENFP_%EC%82%AC%EC%9A%B4%EB%93%9C%EC%98%A4%EB%B8%8C%EB%AE%A4%EC%A7%81.png"),
            new Image("https://mbti-image-server.s3.ap-northeast-2.amazonaws.com/movie-character/movie-character/character_ENFP_%EB%A7%88%EB%A6%AC%EC%95%84.png"),
            new Image("https://mbti-image-server.s3.ap-northeast-2.amazonaws.com/character-Big-Image/character-Big-Image/big_ENFP_%EC%82%AC%EC%9A%B4%EB%93%9C+%EC%98%A4%EB%B8%8C+%EB%AE%A4%EC%A7%81_%EB%A7%88%EB%A6%AC%EC%95%84.png"),
            "남을 배려하는<br>성격을 가지고 있어요.",
            List.of("얼굴에 감정이 드러나는 편이에요.", "창의력과 아이디어가 뛰어나요.", "새로운 사람을 만나는 게 좋아요.",
                    "말하는 것을 좋아해요.", "반복적인 일을 싫어해요.", "고집이 센 편이에요.",
                    "하고싶은 것을 해야 직성이 풀려요.", "임기응변 능력이 뛰어나요.", "승부욕이 강해요.",
                    "거짓말하는 것을 싫어해요.")),
    ENFJ(
            new Image("https://mbti-image-server.s3.ap-northeast-2.amazonaws.com/movie-title/movie-title/title_ENFJ_%EA%B8%88%EB%B0%9C%EC%9D%B4+%EB%84%88%EB%AC%B4%ED%95%B4.png"),
            new Image("https://mbti-image-server.s3.ap-northeast-2.amazonaws.com/movie-character/movie-character/character_ENFJ_%EC%97%98%EC%9A%B0%EC%A6%88.png"),
            new Image("https://mbti-image-server.s3.ap-northeast-2.amazonaws.com/character-Big-Image/character-Big-Image/big_ENFJ_%EA%B8%88%EB%B0%9C%EC%9D%B4+%EB%84%88%EB%AC%B4%ED%95%B4_%EC%97%98+%EC%9A%B0%EC%A6%88.png"),
            "호기심이 많은<br>성격을 가지고 있어요.",
            List.of("사람에 대한 관심이 매우 많아요.", "마음이 약한 편이에요.", "적극적이고 추진력이 강해요.",
                    "결과보다는 과정이 중요해요.", "화를 참는 편이에요.", "걱정이 많으나 티를 내지 않아요.",
                    "맺고 끊는 것을 잘 못해요.", "자기관리에 철저해요.", "감정의 기복이 심한 편이에요.",
                    "남의 말을 의심 없이 잘 믿어요."))
    ;

    private final Image movieName;
    private final Image name;
    private final Image image;
    private final String representativePersonality;
    private final List<String> personalities;

    MbtiCharacterLarge(Image movieName, Image name, Image image, String representativePersonality, List<String> personalities) {
        this.movieName = movieName;
        this.name = name;
        this.image = image;
        this.representativePersonality = representativePersonality;
        this.personalities = personalities;
    }
}
