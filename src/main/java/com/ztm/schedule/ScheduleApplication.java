package com.ztm.schedule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class ScheduleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScheduleApplication.class, args);
	}

	@PostConstruct
	public void method(){
		RestTemplate template = new RestTemplate();
		String url = "https://api.um.warszawa.pl/api/action/dbtimetable_get/?id=e923fa0e-d96c-43f9-ae6e-60518c9f3238&busstopId=7009&busstopNr=01&line=523&apikey=d6361ada-beac-4c41-909a-3f261817b25e";
		ResponseEntity<String> response = template.getForEntity(url,String.class);
		System.out.println(response.toString());
	}
}
