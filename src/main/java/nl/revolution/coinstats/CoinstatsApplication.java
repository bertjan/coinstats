package nl.revolution.coinstats;

import com.fasterxml.jackson.databind.ObjectMapper;
import nl.revolution.coinstats.coinmarketcap.CoinMarketCapService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.fasterxml.jackson.module.kotlin.*;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableScheduling
public class CoinstatsApplication {

	@Bean
	public ObjectMapper objectMapper() {
		return new ObjectMapper().registerModule(new KotlinModule());
	}

	@Bean
	public CoinMarketCapService coinMarketCapService() {
		return new CoinMarketCapService();
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(CoinstatsApplication.class, args);
	}
}
