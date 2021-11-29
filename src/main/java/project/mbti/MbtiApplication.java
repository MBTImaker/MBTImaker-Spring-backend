package project.mbti;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@EnableJpaAuditing
@SpringBootApplication
public class MbtiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MbtiApplication.class, args);
	}

	@PostConstruct
	void init(){
		TimeZone.setDefault(TimeZone.getTimeZone("Asia/Seoul"));
	}
}
