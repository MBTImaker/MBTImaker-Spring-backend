package project.mbti.test.dto.mbti;

import lombok.Getter;

import java.util.List;

@Getter
public class Character {

    private final Image movieName;
    private final Image name;
    private final Image image;
    private final String representativePersonality;
    private final List<String> personalities;

    public Character(MbtiCharacterLarge mbtiCharacterLarge) {
        this.movieName = mbtiCharacterLarge.getMovieName();
        this.name = mbtiCharacterLarge.getName();
        this.image = mbtiCharacterLarge.getImage();
        this.representativePersonality = mbtiCharacterLarge.getRepresentativePersonality();
        this.personalities = mbtiCharacterLarge.getPersonalities();
    }
}
