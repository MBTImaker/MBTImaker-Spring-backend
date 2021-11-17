package project.mbti.mbti;

import lombok.Getter;

import java.util.List;

@Getter
public enum MBTIResult {

    ISTJ(new TestResult(
            new Character(
                    new Image("킹스맨", "https://drive.google.com/uc?export=view&id=1QUuf1lcCGUdv8bf-Y11phtBRQTVT_HFX"),
                    new Image("해리 하트", "https://drive.google.com/uc?export=view&id=1sCzk7GcTUMR940Emep4y-TXlO1n9-tj6"),
                    new Image("킹스맨_해리 하트", "https://drive.google.com/uc?export=view&id=1b_7JUmJAEsefEZlGLLb0YGgdeotMBoCu"),
                    "원리원칙을 지키는\n성격을 가지고 있어요.",
                    List.of("낯가림이 심한 편이에요.", "주어진 업무나 책임을 끝까지 완수해요.", "실수한 것을 참지 못해요.",
                            "참고 참았다가 터뜨리는 편이에요.", "직설적인 표현을 많이 하는 편이에요.", "사고방식이 로봇 같아서 냉정한 사람처럼 보여요.",
                            "정리정돈을 우선시해요.", "현실적, 대중적인 것들을 좋아해요.", "의젓한 성격을 가지고 있어요.",
                            "예고없는 갑작스러운 변화는 싫어요.")),
            new Chemistry(new Image("수어사이드 스쿼드_할리퀸", "https://drive.google.com/uc?export=view&id=1j9PipZ2BKgGXLdVBieBsZxtmqGmvuhSo"), "수어사이드 스쿼드", "할리퀸"),
            new Chemistry(new Image("신비한 동물사전_뉴트 스캐맨더", "https://drive.google.com/uc?export=view&id=1PMoj6Bnc0bOy9RaEVhTYs4ofaA3VE8Hz"), "신비한 동물사전", "뉴트 스캐맨더"),
            List.of(
                    new Image("인셉션","https://drive.google.com/uc?export=view&id=1_rH83nl2Jyla76ZogKMFIUqX73yDIBuD"),
                    new Image("월-E","https://drive.google.com/uc?export=view&id=1QjS0mNHd99lzgomB4z3CN3cRIy71g4A3"),
                    new Image("내니맥피","https://drive.google.com/uc?export=view&id=1-kYcSdB7d904dhGC65LTCymkN3LKGouw")
            )
    )),
    ISFJ(new TestResult(
            new Character(
                    new Image("셜록홈즈","https://drive.google.com/uc?export=view&id=1XumUQJmPesBfqisMrLbE_76L0B0P1w8C"),
                    new Image("왓슨","https://drive.google.com/uc?export=view&id=1T8mO5cXSvJRCywgnEZRuO9EiSpTdkCsp"),
                    new Image("셜록홈즈_왓슨","https://drive.google.com/uc?export=view&id=1KHWgEzWx3t9h86gpJkjXJSMUmPQDVPmF"),
                    "솔직하고 섬세한\n성격을 가지고 있어요.",
                    List.of("눈치가 빠른 편이에요.", "약속을 중요하게 여겨요.", "체계적이에요.",
                            "공감 능력이 뛰어나요.", "솔직하고 섬세해요.", "쓸모없는 낭비를 싫어해요.",
                            "생각이 많은 편이에요.", "인간관계에서 스트레스를 많이 받아요.", "성격이 온화한 편이에요.",
                            "계획 세우는 걸 좋아해요.")),
            new Chemistry(new Image("라푼젤_플린 라이더","https://drive.google.com/uc?export=view&id=1AO6IvWAV79Evar8ltPFwYsIfKWUAv75p"), "라푼젤", "플린 라이더"),
            new Chemistry(new Image("사운드 오브 뮤직_마리아","https://drive.google.com/uc?export=view&id=1p9-XiiIv4LjAu9LLIKNYjIEVeCqJEalw"), "사운드 오브 뮤직", "마리아"),
            List.of(
                    new Image("작은 아씨들","https://drive.google.com/uc?export=view&id=1-rDU60UJR9-Ux6do_naTJJGyS9RRKaXH"),
                    new Image("라라랜드","https://drive.google.com/uc?export=view&id=1BOLe-qwCq-2JUdUJfSNmdduLaB4uOKUA"),
                    new Image("주토피아","https://drive.google.com/uc?export=view&id=1OISrFgW_YYAECJI-qMIxO6einMa8WU4-")
            )
    )),
    ISTP(new TestResult(
            new Character(
                    new Image("007","https://drive.google.com/uc?export=view&id=1XEkfSClj9z1qRNfs6QUpaaJIKuYLA-ud"),
                    new Image("제임스 본드","https://drive.google.com/uc?export=view&id=1lrW1FeczmO2yhQw-WwEWnADCxvMmyBnj"),
                    new Image("007_제임스 본드","https://drive.google.com/uc?export=view&id=1MozZbmsZKdG07czaezwFX1m2JD7N-kbA"),
                    "논리적인\n성격을 가지고 있어요.",
                    List.of("조용하고 과묵해요.", "객관적인 편이에요.", "상황을 파악하는 능력이 있어요.",
                            "감정 표현하기를 어려워해요.", "순간 집중력이 좋아요.", "분석 능력, 관찰력이 좋아요.",
                            "귀찮아하는 게 많아요.", "공감능력이 다소 부족해요.", "혼자 시간을 보내는 걸 좋아해요.",
                            "사람과 관계 맺는 걸 어려워해요.")),
            new Chemistry(new Image("셜록홈즈_왓슨","https://drive.google.com/uc?export=view&id=1EnqzKD5iTsr8jE4Qdl4wlLQyiSDexAJ3"), "셜록홈즈", "왓슨"),
            new Chemistry(new Image("위대한 개츠비_개츠비","https://drive.google.com/uc?export=view&id=19sSJgBMRUpbDp6uo-v8eeYa9qxvNud72"), "위대한 개츠비", "개츠비"),
            List.of(
                    new Image("인터스텔라","https://drive.google.com/uc?export=view&id=1dngnCyYe9_CeuwDtJCloKvKMpD9Lu1Wt"),
                    new Image("매드맥스","https://drive.google.com/uc?export=view&id=1EDdfE7WU4BouPWOd1h_sVRVVaoNw7OU6"),
                    new Image("메이즈러너","https://drive.google.com/uc?export=view&id=1lN00q6SE-gA4X5jM5gjJW98lcorT6hlk")
            )
    )),
    ISFP(new TestResult(
            new Character(
                    new Image("타이타닉","https://drive.google.com/uc?export=view&id=17dRg_bEpq8Y3r8f1njXDe-4YrJqA4nnP"),
                    new Image("로즈","https://drive.google.com/uc?export=view&id=1SMlwH_ICaiTgb9sGc91W23T-22_s0Hfy"),
                    new Image("타이타닉_로즈","https://drive.google.com/uc?export=view&id=1MHcqXsN0Zxh8gkXiLcdMP9ejpcK-Omox"),
                    "이해력이 깊은\n성격을 가지고 있어요.",
                    List.of("사는 데 있어서 즐거움을 추구해요.", "다른 사람의 부탁을 거절하기 힘들어요.", "마음이 순하고 정이 많아요.",
                            "사람을 잘 의심하지 않아요.", "겸손한 편이에요.", "규칙에 얽매이지 않아요.",
                            "집착하는 것을 극도로 싫어해요.", "결단력이 다소 부족해요.", "남 눈치를 보는 편이에요.",
                            "예술적인 감각이 있어요.")),
            new Chemistry(new Image("금발이 너무해_엘 우즈","https://drive.google.com/uc?export=view&id=1WPm2qByE_ib6eSdHVluKkReV0jzqC0Q2"), "금발이 너무해", "엘 우즈"),
            new Chemistry(new Image("신비한 동물사전_뉴트 스캐맨더","https://drive.google.com/uc?export=view&id=1PMoj6Bnc0bOy9RaEVhTYs4ofaA3VE8Hz"), "신비한 동물사전", "뉴트 스캐맨더"),
            List.of(
                    new Image("위플래쉬","https://drive.google.com/uc?export=view&id=12YuC1GxLvKXHLNoonDD0YIj8bUdufox4"),
                    new Image("어바웃타임","https://drive.google.com/uc?export=view&id=1Nu-gWufj15E_dtzqWYnp1vhZxcrenxeV"),
                    new Image("8 Mile","https://drive.google.com/uc?export=view&id=1z5n8SzSX0nPOKKKP6IAg52ijV7dlpN-5")
            )
    )),
    INTJ(new TestResult(
            new Character(
                    new Image("닥터 스트레인지","https://drive.google.com/uc?export=view&id=12gf5mW7zxCCEsf_ronkG63tM8AutYP9r"),
                    new Image("닥터 스트레인지","https://drive.google.com/uc?export=view&id=1JUmH2ZavQHMPS3c4WiOdlW7hx4uvemlw"),
                    new Image("닥터 스트레인지_닥터 스트레인지","https://drive.google.com/uc?export=view&id=1Ts0IQtpEvNHLwKKLdajaALrc-YO7jIY_"),
                    "침착한\n성격을 가지고 있어요.",
                    List.of("논리적이고 객관적이에요.", "일관성있는 걸 좋아해요.", "합리적이며 공정성을 중시해요.",
                            "생각이 많은 편이에요.", "말하기 전에 여러 생각을 거치는 편이에요.", "하고자하는 것이 있으면 하는 편이에요.",
                            "플랜 B를 항상 생각해두는 편이에요.", "인간관계가 좁고 깊은 편이에요.", "통제력이 강한 편이에요.",
                            "목표 지향적이에요.")),
            new Chemistry(new Image("사운드 오브 뮤직_마리아","https://drive.google.com/uc?export=view&id=1p9-XiiIv4LjAu9LLIKNYjIEVeCqJEalw"), "사운드 오브 뮤직", "마리아"),
            new Chemistry(new Image("셜록홈즈_왓슨","https://drive.google.com/uc?export=view&id=1EnqzKD5iTsr8jE4Qdl4wlLQyiSDexAJ3"), "셜록홈즈", "왓슨"),
            List.of(
                    new Image("오만과 편견","https://drive.google.com/uc?export=view&id=1pN34XXMwlfXhq0QvfZi04zDvGbOBhFF8"),
                    new Image("이터널 선샤인","https://drive.google.com/uc?export=view&id=1rZ04XKN0PwxkG_ggkxxsQ4Usnkh9h39S"),
                    new Image("스쿨 오브 락","https://drive.google.com/uc?export=view&id=1yAvm6i-sIKs8yY1cfwHi3LMd0zvlQ23n")
            )
    )),
    INTP(new TestResult(
            new Character(
                    new Image("이미테이션 게임","https://drive.google.com/uc?export=view&id=1A2IVocKiV7fNt36WjmTOkxtL1gFCsKq5"),
                    new Image("앨런 튜링","https://drive.google.com/uc?export=view&id=1iIe0x9pCU9JbggXgXhDLdBzOkC_gJoXZ"),
                    new Image("이미테이션 게임_앨런 튜링","https://drive.google.com/uc?export=view&id=1K3by4o1C0MC9wfK0jUhRwJGbEFEXcPHo"),
                    "정직한\n성격을 가지고 있어요.",
                    List.of("다방면으로 관심이 많아요.", "자신만의 세계가 뚜렷해요.", "혼자만의 시간이 매우 중요해요.",
                            "반항심이 강한 편이에요.", "관심사에 한 번 꽂히면 헤어나오지 못해요.", "계획보다는 즉흥이 좋아요.",
                            "공상을 자주 하는 편이에요.", "분석 또는 추리를 좋아해요.", "지식에 대한 욕심이 많아요.",
                            "감수성이 풍부해요.")),
            new Chemistry(new Image("악마는 프라다를 입는다_미란다","https://drive.google.com/uc?export=view&id=1BUx6vqZ3zsrWU5iOU6jGLsebBVBaKJ5Y"), "악마는 프라다를 입는다", "미란다"),
            new Chemistry(new Image("분노의 질주_돔","https://drive.google.com/uc?export=view&id=1wW9ykg2V3AXaSAHK9Htj71GAIstHnqCI"), "분노의 질주", "돔"),
            List.of(
                    new Image("굿 윌 헌팅","https://drive.google.com/uc?export=view&id=1dWhI9i4tf3MUkasBkcTDCAnqjgLl-3cv"),
                    new Image("소셜 네트워크","https://drive.google.com/uc?export=view&id=1UwI-Mf0Z8VTcCaq77pPKYgKzXRzx-UyJ"),
                    new Image("히든 피겨스","https://drive.google.com/uc?export=view&id=1k359VhJrWxNUjIrYK0FijL1iYy_p_9FC")
            )
    )),
    INFJ(new TestResult(
            new Character(
                    new Image("위대한 개츠비","https://drive.google.com/uc?export=view&id=1ARckR43e92CO26s9hgrX77xQWUKr98qz"),
                    new Image("개츠비","https://drive.google.com/uc?export=view&id=1_DKPqmcAAA-lOi_XAfXhm4o4V4F-ju00"),
                    new Image("위대한 개츠비_개츠비","https://drive.google.com/uc?export=view&id=1xW-_dlqnbOHVdkMUQUfF4vaTd-k8ida4"),
                    "감수성이 풍부한\n성격을 가지고 있어요.",
                    List.of("직관력과 관찰력이 뛰어나요.", "공감 능력이 뛰어나요.", "다소 내성적이에요.",
                            "호불호가 분명하게 나뉘어요.", "상상력과 창의력이 뛰어나요.", "계획적인 것을 좋아해요.",
                            "인내심이 많은 편이에요.", "분쟁과 다툼을 싫어해요.", "호기심이 많아요.",
                            "번아웃에 취약해요.")),
            new Chemistry(new Image("사운드 오브 뮤직_마리아","https://drive.google.com/uc?export=view&id=1p9-XiiIv4LjAu9LLIKNYjIEVeCqJEalw"), "사운드 오브 뮤직", "마리아"),
            new Chemistry(new Image("타이타닉_로즈","https://drive.google.com/uc?export=view&id=1vguDZzQww3VQGEQBHdSwfSyokGVgOQon"), "타이타닉", "로즈"),
            List.of(
                    new Image("컨택트","https://drive.google.com/uc?export=view&id=1uPhRXXDQH2v79GbyZQ3YfmCCIqhaMUaB"),
                    new Image("버드박스","https://drive.google.com/uc?export=view&id=1HaxpbcFh8JyNRxo3Ly-c2Voi_bfRS1aG"),
                    new Image("어톤먼트","https://drive.google.com/uc?export=view&id=1llHk1D6dVuN08bMCIEOw9zMHvJGds4BV")
            )
    )),
    INFP(new TestResult(
            new Character(
                    new Image("신비한 동물사전","https://drive.google.com/uc?export=view&id=1373IFWhgvBVtR9wXaxcM8dVGD-q2yqZQ"),
                    new Image("뉴트 스캐맨더","https://drive.google.com/uc?export=view&id=1MDqeqoR91OSRuL_Qll6FP1rb3VRJLJuj"),
                    new Image("신비한 동물사전_뉴트 스캐맨더","https://drive.google.com/uc?export=view&id=1W_a7vZ0eKrKw3oCBQgI70utmUnWUfUOb"),
                    "침착하고 디테일한\n성격을 가지고 있어요.",
                    List.of("성격이 세심하고 디테일해요.", "자기 자신에 대한 애정이 강해요.", "가식적인 것을 싫어해요.",
                            "본인의 영역 침범을 매우 싫어해요.", "몽상가적인 면이 있어요.", "스스로에 대해 깊은 고찰을 하는 편이에요.",
                            "스스로에 대한 평가가 박한 편이에요.", "창의성이 좋아요.", "개인적인 생각을 잘 털어놓지 않아요.",
                            "화를 잘 표출하지 않아요.")),
            new Chemistry(new Image("금발이 너무해_엘 우즈","https://drive.google.com/uc?export=view&id=1WPm2qByE_ib6eSdHVluKkReV0jzqC0Q2"), "금발이 너무해", "엘 우즈"),
            new Chemistry(new Image("타이타닉_로즈","https://drive.google.com/uc?export=view&id=1vguDZzQww3VQGEQBHdSwfSyokGVgOQon"), "타이타닉", "로즈"),
            List.of(
                    new Image("월 플라워","https://drive.google.com/uc?export=view&id=1rPmxpGFyiAevHcUEJTRMrotTnu3Ucmj7"),
                    new Image("프린세스 다이어리","https://drive.google.com/uc?export=view&id=1jeSCFeStWjX8FrlKM8uuu4pWfOxpgscI"),
                    new Image("아멜리에","https://drive.google.com/uc?export=view&id=1HEUKMm7H99t887L0uNRGSYyBBXTTnaPt")
            )
    )),
    ;

    private TestResult testResult;

    MBTIResult(TestResult testResult) {
        this.testResult = testResult;
    }
}
