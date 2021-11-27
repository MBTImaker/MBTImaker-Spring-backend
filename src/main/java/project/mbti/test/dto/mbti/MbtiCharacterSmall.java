package project.mbti.test.dto.mbti;

import lombok.Getter;

@Getter
public enum MbtiCharacterSmall {

    ISTJ("킹스맨", "해리 하트", "https://drive.google.com/uc?export=view&id=10JfXfUuMmJT15qEE1NkGtbOz_vIp71Ct"),
    ISTP("007", "제임스 본드", "https://drive.google.com/uc?export=view&id=10JfXfUuMmJT15qEE1NkGtbOz_vIp71Ct"),
    ISFP("타이타닉", "로즈", "https://drive.google.com/uc?export=view&id=1vguDZzQww3VQGEQBHdSwfSyokGVgOQon"),
    ISFJ("셜록홈즈", "왓슨", "https://drive.google.com/uc?export=view&id=1EnqzKD5iTsr8jE4Qdl4wlLQyiSDexAJ3"),
    INTP("이미테이션 게임", "앨런 튜링", "https://drive.google.com/uc?export=view&id=1H2IVO5Y1RFc8fdgCq5vbH5vB_2dj54Hy"),
    INTJ("닥터 스트레인지", "닥터 스트레인지", "https://drive.google.com/uc?export=view&id=1YWsnuCDPuV-A_FLEXopF87oJk1arV8jS"),
    INFP("신비한 동물사전", "뉴트 스캐맨더", "https://drive.google.com/uc?export=view&id=1PMoj6Bnc0bOy9RaEVhTYs4ofaA3VE8Hz"),
    INFJ("위대한 개츠비", "개츠비", "https://drive.google.com/uc?export=view&id=19sSJgBMRUpbDp6uo-v8eeYa9qxvNud72"),
    ESTP("라푼젤", "플린 라이더", "https://drive.google.com/uc?export=view&id=1AO6IvWAV79Evar8ltPFwYsIfKWUAv75p"),
    ESTJ("해리포터", "헤르미온느", "https://drive.google.com/uc?export=view&id=10UF5nGVrJVLSnJLT6pYhJwyW-GoFu5bh"),
    ESFP("수어사이드 스쿼드", "할리퀸", "https://drive.google.com/uc?export=view&id=1j9PipZ2BKgGXLdVBieBsZxtmqGmvuhSo"),
    ESFJ("분노의 질주", "돔", "https://drive.google.com/uc?export=view&id=1wW9ykg2V3AXaSAHK9Htj71GAIstHnqCI"),
    ENTP("크리스마스의 악몽", "잭 스켈레톤", "https://drive.google.com/uc?export=view&id=1f1guSAIMoN2axUpbHbkhQTA64bFm_ICY"),
    ENTJ("악마는 프라다를 입는다", "미란다", "https://drive.google.com/uc?export=view&id=1BUx6vqZ3zsrWU5iOU6jGLsebBVBaKJ5Y"),
    ENFP("사운드 오브 뮤직", "마리아", "https://drive.google.com/uc?export=view&id=1p9-XiiIv4LjAu9LLIKNYjIEVeCqJEalw"),
    ENFJ("금발이 너무해", "엘 우즈", "https://drive.google.com/uc?export=view&id=1WPm2qByE_ib6eSdHVluKkReV0jzqC0Q2"),
    ;

    private final String movieName;
    private final String characterName;
    private final String imageUrl;

    MbtiCharacterSmall(String movieName, String characterName, String imageUrl) {
        this.movieName = movieName;
        this.characterName = characterName;
        this.imageUrl = imageUrl;
    }
}
