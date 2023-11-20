package mumage.mumagebackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import java.util.TimeZone;

@SpringBootApplication
@EnableJpaAuditing //Auditing 기능 활성화
public class MumageBackendApplication {

	@PostConstruct
	void timeSet(){
		TimeZone.setDefault(TimeZone.getTimeZone("Asia/Seoul"));
	}

	public static void main(String[] args) {
		SpringApplication.run(MumageBackendApplication.class, args);
	}

}
