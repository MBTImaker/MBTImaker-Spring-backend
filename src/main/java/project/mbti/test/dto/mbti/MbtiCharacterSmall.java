package project.mbti.test.dto.mbti;

import lombok.Getter;

@Getter
public enum MbtiCharacterSmall {

    ISTJ("킹스맨", "해리 하트", "https://mbti-test.herokuapp.com/character-Small-Image/small_ISTJ_킹스맨_해리_하트.png"),
    ISTP("007", "제임스 본드", "https://mbti-test.herokuapp.com/character-Small-Image/small_ISTP_007_제임스_본드.png"),
    ISFP("타이타닉", "로즈", "https://mbti-test.herokuapp.com/character-Small-Image/small_ISFP_타이타닉_로즈.png"),
    ISFJ("셜록홈즈", "왓슨", "https://mbti-test.herokuapp.com/character-Small-Image/small_ISFJ_셜록홈즈_왓슨.png"),
    INTP("이미테이션 게임", "앨런 튜링", "https://mbti-test.herokuapp.com/character-Small-Image/small_INTP_이미테이션_게임_앨런_튜링.png"),
    INTJ("닥터 스트레인지", "닥터 스트레인지", "https://mbti-test.herokuapp.com/character-Small-Image/small_INTJ_닥터_스트레인지_닥터_스트레인지.png"),
    INFP("신비한 동물사전", "뉴트 스캐맨더", "https://mbti-test.herokuapp.com/character-Small-Image/small_INFP_%EC%8B%A0%EB%B9%84%ED%95%9C_%EB%8F%99%EB%AC%BC%EC%82%AC%EC%A0%84__%EB%89%B4%ED%8A%B8_%EC%8A%A4%EC%BA%90%EB%A7%A8%EB%8D%94.png"),
    INFJ("위대한 개츠비", "개츠비", "https://mbti-test.herokuapp.com/character-Small-Image/small_INFJ_%EC%9C%84%EB%8C%80%ED%95%9C_%EA%B0%9C%EC%B8%A0%EB%B9%84_%EA%B0%9C%EC%B8%A0%EB%B9%84.png"),
    ESTP("라푼젤", "플린 라이더", "https://mbti-test.herokuapp.com/character-Small-Image/small_ESTP_%EB%9D%BC%ED%91%BC%EC%A0%A4_%ED%94%8C%EB%A6%B0_%EB%9D%BC%EC%9D%B4%EB%8D%94.png"),
    ESTJ("해리포터", "헤르미온느", "https://mbti-test.herokuapp.com/character-Small-Image/small_ESTJ_%ED%95%B4%EB%A6%AC%ED%8F%AC%ED%84%B0_%ED%97%A4%EB%A5%B4%EB%AF%B8%EC%98%A8%EB%8A%90.png"),
    ESFP("수어사이드 스쿼드", "할리퀸", "https://mbti-test.herokuapp.com/character-Small-Image/small_ESFP_%EC%88%98%EC%96%B4%EC%82%AC%EC%9D%B4%EB%93%9C_%EC%8A%A4%EC%BF%BC%EB%93%9C_%ED%95%A0%EB%A6%AC%ED%80%B8.png"),
    ESFJ("분노의 질주", "돔", "https://mbti-test.herokuapp.com/character-Small-Image/small_ESFJ_%EB%B6%84%EB%85%B8%EC%9D%98_%EC%A7%88%EC%A3%BC_%EB%8F%94.png"),
    ENTP("크리스마스의 악몽", "잭 스켈레톤", "https://mbti-test.herokuapp.com/character-Small-Image/small_ENTP_%ED%81%AC%EB%A6%AC%EC%8A%A4%EB%A7%88%EC%8A%A4%EC%9D%98_%EC%95%85%EB%AA%BD_%EC%9E%AD_%EC%8A%A4%EC%BC%88%EB%A0%88%ED%86%A4.png"),
    ENTJ("악마는 프라다를 입는다", "미란다", "https://mbti-test.herokuapp.com/character-Small-Image/small_ENTJ_%EC%95%85%EB%A7%88%EB%8A%94_%ED%94%84%EB%9D%BC%EB%8B%A4%EB%A5%BC_%EC%9E%85%EB%8A%94%EB%8B%A4_%EB%AF%B8%EB%9E%80%EB%8B%A4.png"),
    ENFP("사운드 오브 뮤직", "마리아", "https://mbti-test.herokuapp.com/character-Small-Image/small_ENFP_%EC%82%AC%EC%9A%B4%EB%93%9C_%EC%98%A4%EB%B8%8C_%EB%AE%A4%EC%A7%81_%EB%A7%88%EB%A6%AC%EC%95%84.png"),
    ENFJ("금발이 너무해", "엘 우즈", "https://mbti-test.herokuapp.com/character-Small-Image/small_ENFJ_%EA%B8%88%EB%B0%9C%EC%9D%B4_%EB%84%88%EB%AC%B4%ED%95%B4_%EC%97%98_%EC%9A%B0%EC%A6%88.png"),
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
