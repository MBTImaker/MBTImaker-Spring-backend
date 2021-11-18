package project.mbti.test.dto.mbti;

import lombok.Getter;

@Getter
public class Chemistry {

    private final String movieName;
    private final String characterName;
    private final String imageUrl;

    public Chemistry(MbtiCharacterSmall mbtiCharacterSmall) {
        this.movieName = mbtiCharacterSmall.getMovieName();
        this.characterName = mbtiCharacterSmall.getCharacterName();
        this.imageUrl = mbtiCharacterSmall.getImageUrl();
    }
}
