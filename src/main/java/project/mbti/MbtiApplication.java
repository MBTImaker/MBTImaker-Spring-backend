package project.mbti;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class MbtiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MbtiApplication.class, args);
	}
}