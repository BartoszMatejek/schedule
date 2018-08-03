package com.ztm.schedule;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ztm.schedule.model.Root;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URL;

@SpringBootApplication
public class ScheduleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScheduleApplication.class, args);
	}

	@PostConstruct
	public void method(){
		ObjectMapper objectMapper = new ObjectMapper();
		try{
			URL url = new URL("https://api.um.warszawa.pl/api/action/dbtimetable_get/?id=e923fa0e-d96c-43f9-ae6e-60518c9f3238&busstopId=7009&busstopNr=01&line=523&apikey=d6361ada-beac-4c41-909a-3f261817b25e");
			Root root = objectMapper.readValue(url, Root.class);
			System.out.println(root.toString());
			System.out.println("GOOD");
		}catch(IOException e){
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
