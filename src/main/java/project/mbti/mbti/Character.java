package project.mbti.mbti;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class Character {

    private String movieName;
    private String name;
    private Image image;
    private String representativePersonality;
    private List<String> personalities;
}
