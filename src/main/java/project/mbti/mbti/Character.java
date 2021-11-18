package project.mbti.mbti;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class Character {

    private Image movieName;
    private Image name;
    private Image image;
    private String representativePersonality;
    private List<String> personalities;
}
