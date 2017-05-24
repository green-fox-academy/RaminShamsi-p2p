package hu.greenfox.ramin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.io.IOException;
import java.util.Map;


@SpringBootApplication
//@ComponentScan
public class ChatappApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChatappApplication.class, args);
//		ProcessBuilder pb = new ProcessBuilder("setx", "CHAT_APP_LOGLEVEL","ERROR");
		// the "CHAT_APP_LOGLEVEL" variable and Value=ERROR was set at Run->EditConfiguration->SpringBoot->EnviromentalVariables
		// then in Heroku setting also we can define same variable and change the value to ERROR or something else
//		System.out.println(System.getenv("CHAT_APP_LOGLEVEL"));
	}
}
