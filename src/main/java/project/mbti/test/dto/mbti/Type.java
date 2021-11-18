package project.mbti.test.dto.mbti;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class Type {

    private final String movieName;
    private final String characterName;
    private final String imageUrl;
    private final int percentage;
}
