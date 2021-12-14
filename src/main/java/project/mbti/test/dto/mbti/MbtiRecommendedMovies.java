package project.mbti.test.dto.mbti;

import lombok.Getter;

import java.util.List;

@Getter
public enum MbtiRecommendedMovies {

    ISTJ(List.of(
            new Image("https://mbti-image-server.s3.ap-northeast-2.amazonaws.com/movie-Image/movie-Image/movie_ISTJ_%ED%82%B9%EC%8A%A4%EB%A7%A8_%ED%95%B4%EB%A6%AC+%ED%95%98%ED%8A%B8(1).png"),
            new Image("https://mbti-image-server.s3.ap-northeast-2.amazonaws.com/movie-Image/movie-Image/movie_ISTJ_%ED%82%B9%EC%8A%A4%EB%A7%A8_%ED%95%B4%EB%A6%AC+%ED%95%98%ED%8A%B8(2).png"),
            new Image("https://mbti-image-server.s3.ap-northeast-2.amazonaws.com/movie-Image/movie-Image/movie_ISTJ_%ED%82%B9%EC%8A%A4%EB%A7%A8_%ED%95%B4%EB%A6%AC+%ED%95%98%ED%8A%B8(3).png"))),
    ISFJ(List.of(
            new Image("https://mbti-image-server.s3.ap-northeast-2.amazonaws.com/movie-Image/movie-Image/movie_ISFJ_%EC%85%9C%EB%A1%9D%ED%99%88%EC%A6%88_%EC%99%93%EC%8A%A8(1).png"),
            new Image("https://mbti-image-server.s3.ap-northeast-2.amazonaws.com/movie-Image/movie-Image/movie_ISFJ_%EC%85%9C%EB%A1%9D%ED%99%88%EC%A6%88_%EC%99%93%EC%8A%A8(2).png"),
            new Image("https://mbti-image-server.s3.ap-northeast-2.amazonaws.com/movie-Image/movie-Image/movie_ISFJ_%EC%85%9C%EB%A1%9D%ED%99%88%EC%A6%88_%EC%99%93%EC%8A%A8(3).png"))),
    ISTP(List.of(
            new Image("https://mbti-image-server.s3.ap-northeast-2.amazonaws.com/movie-Image/movie-Image/movie_ISTP_007_%EC%A0%9C%EC%9E%84%EC%8A%A4+%EB%B3%B8%EB%93%9C(1).png"),
            new Image("https://mbti-image-server.s3.ap-northeast-2.amazonaws.com/movie-Image/movie-Image/movie_ISTP_007_%EC%A0%9C%EC%9E%84%EC%8A%A4+%EB%B3%B8%EB%93%9C(2).png"),
            new Image("https://mbti-image-server.s3.ap-northeast-2.amazonaws.com/movie-Image/movie-Image/movie_ISTP_007_%EC%A0%9C%EC%9E%84%EC%8A%A4+%EB%B3%B8%EB%93%9C(3).png"))),
    ISFP(List.of(
            new Image("https://mbti-image-server.s3.ap-northeast-2.amazonaws.com/movie-Image/movie-Image/movie_ISFP_%ED%83%80%EC%9D%B4%ED%83%80%EB%8B%89_%EB%A1%9C%EC%A6%88(1).png"),
            new Image("https://mbti-image-server.s3.ap-northeast-2.amazonaws.com/movie-Image/movie-Image/movie_ISFP_%ED%83%80%EC%9D%B4%ED%83%80%EB%8B%89_%EB%A1%9C%EC%A6%88(2).png"),
            new Image("https://mbti-image-server.s3.ap-northeast-2.amazonaws.com/movie-Image/movie-Image/movie_ISFP_%ED%83%80%EC%9D%B4%ED%83%80%EB%8B%89_%EB%A1%9C%EC%A6%88(3).png"))),
    INTJ(List.of(
            new Image("https://mbti-image-server.s3.ap-northeast-2.amazonaws.com/movie-Image/movie-Image/movie_INTJ_%EB%8B%A5%ED%84%B0+%EC%8A%A4%ED%8A%B8%EB%A0%88%EC%9D%B8%EC%A7%80_%EB%8B%A5%ED%84%B0+%EC%8A%A4%ED%8A%B8%EB%A0%88%EC%9D%B8%EC%A7%80(1).png"),
            new Image("https://mbti-image-server.s3.ap-northeast-2.amazonaws.com/movie-Image/movie-Image/movie_INTJ_%EB%8B%A5%ED%84%B0+%EC%8A%A4%ED%8A%B8%EB%A0%88%EC%9D%B8%EC%A7%80_%EB%8B%A5%ED%84%B0+%EC%8A%A4%ED%8A%B8%EB%A0%88%EC%9D%B8%EC%A7%80(2).png"),
            new Image("https://mbti-image-server.s3.ap-northeast-2.amazonaws.com/movie-Image/movie-Image/movie_INTJ_%EB%8B%A5%ED%84%B0+%EC%8A%A4%ED%8A%B8%EB%A0%88%EC%9D%B8%EC%A7%80_%EB%8B%A5%ED%84%B0+%EC%8A%A4%ED%8A%B8%EB%A0%88%EC%9D%B8%EC%A7%80(3).png"))),
    INTP(List.of(
            new Image("https://mbti-image-server.s3.ap-northeast-2.amazonaws.com/movie-Image/movie-Image/movie_INTP_%EC%9D%B4%EB%AF%B8%ED%85%8C%EC%9D%B4%EC%85%98+%EA%B2%8C%EC%9E%84_%EC%95%A8%EB%9F%B0+%ED%8A%9C%EB%A7%81(1).png"),
            new Image("https://mbti-image-server.s3.ap-northeast-2.amazonaws.com/movie-Image/movie-Image/movie_INTP_%EC%9D%B4%EB%AF%B8%ED%85%8C%EC%9D%B4%EC%85%98+%EA%B2%8C%EC%9E%84_%EC%95%A8%EB%9F%B0+%ED%8A%9C%EB%A7%81(2).png"),
            new Image("https://mbti-image-server.s3.ap-northeast-2.amazonaws.com/movie-Image/movie-Image/movie_INTP_%EC%9D%B4%EB%AF%B8%ED%85%8C%EC%9D%B4%EC%85%98+%EA%B2%8C%EC%9E%84_%EC%95%A8%EB%9F%B0+%ED%8A%9C%EB%A7%81(3).png"))),
    INFJ(List.of(
            new Image("https://mbti-image-server.s3.ap-northeast-2.amazonaws.com/movie-Image/movie-Image/movie_INFJ_%EC%9C%84%EB%8C%80%ED%95%9C+%EA%B0%9C%EC%B8%A0%EB%B9%84_%EA%B0%9C%EC%B8%A0%EB%B9%84(1).png"),
            new Image("https://mbti-image-server.s3.ap-northeast-2.amazonaws.com/movie-Image/movie-Image/movie_INFJ_%EC%9C%84%EB%8C%80%ED%95%9C+%EA%B0%9C%EC%B8%A0%EB%B9%84_%EA%B0%9C%EC%B8%A0%EB%B9%84(2).png"),
            new Image("https://mbti-image-server.s3.ap-northeast-2.amazonaws.com/movie-Image/movie-Image/movie_INFJ_%EC%9C%84%EB%8C%80%ED%95%9C+%EA%B0%9C%EC%B8%A0%EB%B9%84_%EA%B0%9C%EC%B8%A0%EB%B9%84(3).png"))),
    INFP(List.of(
            new Image("https://mbti-image-server.s3.ap-northeast-2.amazonaws.com/movie-Image/movie-Image/movie_INFP_%EC%8B%A0%EB%B9%84%ED%95%9C+%EB%8F%99%EB%AC%BC%EC%82%AC%EC%A0%84_+%EB%89%B4%ED%8A%B8+%EC%8A%A4%EC%BA%90%EB%A7%A8%EB%8D%94(1).png"),
            new Image("https://mbti-image-server.s3.ap-northeast-2.amazonaws.com/movie-Image/movie-Image/movie_INFP_%EC%8B%A0%EB%B9%84%ED%95%9C+%EB%8F%99%EB%AC%BC%EC%82%AC%EC%A0%84_+%EB%89%B4%ED%8A%B8+%EC%8A%A4%EC%BA%90%EB%A7%A8%EB%8D%94(2).png"),
            new Image("https://mbti-image-server.s3.ap-northeast-2.amazonaws.com/movie-Image/movie-Image/movie_INFP_%EC%8B%A0%EB%B9%84%ED%95%9C+%EB%8F%99%EB%AC%BC%EC%82%AC%EC%A0%84_+%EB%89%B4%ED%8A%B8+%EC%8A%A4%EC%BA%90%EB%A7%A8%EB%8D%94(3).png"))),
    ESTP(List.of(
            new Image("https://mbti-image-server.s3.ap-northeast-2.amazonaws.com/movie-Image/movie-Image/movie_ESTP_%EB%9D%BC%ED%91%BC%EC%A0%A4_%ED%94%8C%EB%A6%B0+%EB%9D%BC%EC%9D%B4%EB%8D%94(1).png"),
            new Image("https://mbti-image-server.s3.ap-northeast-2.amazonaws.com/movie-Image/movie-Image/movie_ESTP_%EB%9D%BC%ED%91%BC%EC%A0%A4_%ED%94%8C%EB%A6%B0+%EB%9D%BC%EC%9D%B4%EB%8D%94(2).png"),
            new Image("https://mbti-image-server.s3.ap-northeast-2.amazonaws.com/movie-Image/movie-Image/movie_ESTP_%EB%9D%BC%ED%91%BC%EC%A0%A4_%ED%94%8C%EB%A6%B0+%EB%9D%BC%EC%9D%B4%EB%8D%94(3).png"))),
    ESTJ(List.of(
            new Image("https://mbti-image-server.s3.ap-northeast-2.amazonaws.com/movie-Image/movie-Image/movie_ESTJ_%ED%95%B4%EB%A6%AC%ED%8F%AC%ED%84%B0_%ED%97%A4%EB%A5%B4%EB%AF%B8%EC%98%A8%EB%8A%90(1).png"),
            new Image("https://mbti-image-server.s3.ap-northeast-2.amazonaws.com/movie-Image/movie-Image/movie_ESTJ_%ED%95%B4%EB%A6%AC%ED%8F%AC%ED%84%B0_%ED%97%A4%EB%A5%B4%EB%AF%B8%EC%98%A8%EB%8A%90(2).png"),
            new Image("https://mbti-image-server.s3.ap-northeast-2.amazonaws.com/movie-Image/movie-Image/movie_ESTJ_%ED%95%B4%EB%A6%AC%ED%8F%AC%ED%84%B0_%ED%97%A4%EB%A5%B4%EB%AF%B8%EC%98%A8%EB%8A%90(3).png"))),
    ESFP(List.of(
            new Image("https://mbti-image-server.s3.ap-northeast-2.amazonaws.com/movie-Image/movie-Image/movie_ESFP_%EC%88%98%EC%96%B4%EC%82%AC%EC%9D%B4%EB%93%9C+%EC%8A%A4%EC%BF%BC%EB%93%9C_%ED%95%A0%EB%A6%AC%ED%80%B8(1).png"),
            new Image("https://mbti-image-server.s3.ap-northeast-2.amazonaws.com/movie-Image/movie-Image/movie_ESFP_%EC%88%98%EC%96%B4%EC%82%AC%EC%9D%B4%EB%93%9C+%EC%8A%A4%EC%BF%BC%EB%93%9C_%ED%95%A0%EB%A6%AC%ED%80%B8(2).png"),
            new Image("https://mbti-image-server.s3.ap-northeast-2.amazonaws.com/movie-Image/movie-Image/movie_ESFP_%EC%88%98%EC%96%B4%EC%82%AC%EC%9D%B4%EB%93%9C+%EC%8A%A4%EC%BF%BC%EB%93%9C_%ED%95%A0%EB%A6%AC%ED%80%B8(3).png"))),
    ESFJ(List.of(
            new Image("https://mbti-image-server.s3.ap-northeast-2.amazonaws.com/movie-Image/movie-Image/movie_ESFJ_%EB%B6%84%EB%85%B8%EC%9D%98+%EC%A7%88%EC%A3%BC_%EB%8F%94(1).png"),
            new Image("https://mbti-image-server.s3.ap-northeast-2.amazonaws.com/movie-Image/movie-Image/movie_ESFJ_%EB%B6%84%EB%85%B8%EC%9D%98+%EC%A7%88%EC%A3%BC_%EB%8F%94(2).png"),
            new Image("https://mbti-image-server.s3.ap-northeast-2.amazonaws.com/movie-Image/movie-Image/movie_ESFJ_%EB%B6%84%EB%85%B8%EC%9D%98+%EC%A7%88%EC%A3%BC_%EB%8F%94(3).png"))),
    ENTP(List.of(
            new Image("https://mbti-image-server.s3.ap-northeast-2.amazonaws.com/movie-Image/movie-Image/movie_ENTP_%ED%81%AC%EB%A6%AC%EC%8A%A4%EB%A7%88%EC%8A%A4%EC%9D%98+%EC%95%85%EB%AA%BD_%EC%9E%AD+%EC%8A%A4%EC%BC%88%EB%A0%88%ED%86%A4(1).png"),
            new Image("https://mbti-image-server.s3.ap-northeast-2.amazonaws.com/movie-Image/movie-Image/movie_ENTP_%ED%81%AC%EB%A6%AC%EC%8A%A4%EB%A7%88%EC%8A%A4%EC%9D%98+%EC%95%85%EB%AA%BD_%EC%9E%AD+%EC%8A%A4%EC%BC%88%EB%A0%88%ED%86%A4(2).png"),
            new Image("https://mbti-image-server.s3.ap-northeast-2.amazonaws.com/movie-Image/movie-Image/movie_ENTP_%ED%81%AC%EB%A6%AC%EC%8A%A4%EB%A7%88%EC%8A%A4%EC%9D%98+%EC%95%85%EB%AA%BD_%EC%9E%AD+%EC%8A%A4%EC%BC%88%EB%A0%88%ED%86%A4(3).png"))),
    ENTJ(List.of(
            new Image("https://mbti-image-server.s3.ap-northeast-2.amazonaws.com/movie-Image/movie-Image/movie_ENTJ_%EC%95%85%EB%A7%88%EB%8A%94+%ED%94%84%EB%9D%BC%EB%8B%A4%EB%A5%BC+%EC%9E%85%EB%8A%94%EB%8B%A4_%EB%AF%B8%EB%9E%80%EB%8B%A4(1).png"),
            new Image("https://mbti-image-server.s3.ap-northeast-2.amazonaws.com/movie-Image/movie-Image/movie_ENTJ_%EC%95%85%EB%A7%88%EB%8A%94+%ED%94%84%EB%9D%BC%EB%8B%A4%EB%A5%BC+%EC%9E%85%EB%8A%94%EB%8B%A4_%EB%AF%B8%EB%9E%80%EB%8B%A4(2).png"),
            new Image("https://mbti-image-server.s3.ap-northeast-2.amazonaws.com/movie-Image/movie-Image/movie_ENTJ_%EC%95%85%EB%A7%88%EB%8A%94+%ED%94%84%EB%9D%BC%EB%8B%A4%EB%A5%BC+%EC%9E%85%EB%8A%94%EB%8B%A4_%EB%AF%B8%EB%9E%80%EB%8B%A4(3).png"))),
    ENFP(List.of(
            new Image("https://mbti-image-server.s3.ap-northeast-2.amazonaws.com/movie-Image/movie-Image/movie_ENFP_%EC%82%AC%EC%9A%B4%EB%93%9C+%EC%98%A4%EB%B8%8C+%EB%AE%A4%EC%A7%81_%EB%A7%88%EB%A6%AC%EC%95%84(1).png"),
            new Image("https://mbti-image-server.s3.ap-northeast-2.amazonaws.com/movie-Image/movie-Image/movie_ENFP_%EC%82%AC%EC%9A%B4%EB%93%9C+%EC%98%A4%EB%B8%8C+%EB%AE%A4%EC%A7%81_%EB%A7%88%EB%A6%AC%EC%95%84(2).png"),
            new Image("https://mbti-image-server.s3.ap-northeast-2.amazonaws.com/movie-Image/movie-Image/movie_ENFP_%EC%82%AC%EC%9A%B4%EB%93%9C+%EC%98%A4%EB%B8%8C+%EB%AE%A4%EC%A7%81_%EB%A7%88%EB%A6%AC%EC%95%84(3).png"))),
    ENFJ(List.of(
            new Image("https://mbti-image-server.s3.ap-northeast-2.amazonaws.com/movie-Image/movie-Image/movie_ENFJ_%EA%B8%88%EB%B0%9C%EC%9D%B4+%EB%84%88%EB%AC%B4%ED%95%B4_%EC%97%98+%EC%9A%B0%EC%A6%88(1).png"),
            new Image("https://mbti-image-server.s3.ap-northeast-2.amazonaws.com/movie-Image/movie-Image/movie_ENFJ_%EA%B8%88%EB%B0%9C%EC%9D%B4+%EB%84%88%EB%AC%B4%ED%95%B4_%EC%97%98+%EC%9A%B0%EC%A6%88(2).png"),
            new Image("https://mbti-image-server.s3.ap-northeast-2.amazonaws.com/movie-Image/movie-Image/movie_ENFJ_%EA%B8%88%EB%B0%9C%EC%9D%B4+%EB%84%88%EB%AC%B4%ED%95%B4_%EC%97%98+%EC%9A%B0%EC%A6%88(3).png")))
    ;

    private final List<Image> images;

    MbtiRecommendedMovies(List<Image> images) {
        this.images = images;
    }
}
