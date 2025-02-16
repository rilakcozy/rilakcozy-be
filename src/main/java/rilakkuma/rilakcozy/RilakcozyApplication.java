package rilakkuma.rilakcozy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class RilakcozyApplication {

	public static void main(String[] args) {
		SpringApplication.run(RilakcozyApplication.class, args);
	}

}
