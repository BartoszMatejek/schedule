package com.ztm.schedule;

import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ztm.schedule.model.Result;
import com.ztm.schedule.model.Root;
import com.ztm.schedule.model.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class ScheduleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScheduleApplication.class, args);
	}

	@PostConstruct
	public void method(){
        ObjectMapper objectMapper = new ObjectMapper();
		String busStopId = null;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Podaj nazwe przystanku");
		String busStopName = scanner.nextLine();

		String fullUrl = "https://api.um.warszawa.pl/api/action/dbtimetable_get?id=e923fa0e-d96c-43f9-ae6e60518c9f3238&busstopId=7009&busstopNr=01&line=523&apikey=wartość";

		String url1 = "https://api.um.warszawa.pl/api/action/dbtimetable_get/?id=b27f4c17-5c50-4a5b-89dd-236b282bc499&name=";
		String url2 ="&apikey=d6361ada-beac-4c41-909a-3f261817b25e";
		String finalUrl = url1+busStopName+url2;

		String lineList = "https://api.um.warszawa.pl/api/action/dbtimetable_get/?id=88cd555f-6f31-43ca-9de4-66c479ad5942&busstopId=";
		String lineList2 = "&busstopNr=01&apikey=d6361ada-beac-4c41-909a-3f261817b25e";
		String finalUrl2 = null;

		String urlTime = "https://api.um.warszawa.pl/api/action/dbtimetable_get/?id=e923fa0e-d96c-43f9-ae6e-60518c9f3238&busstopId=";
		System.out.println("Podaj numer linii");
		String line = scanner.nextLine();
		String urlTime1 = "&busstopNr=01&line=";
		String urlTime2 = "&apikey=d6361ada-beac-4c41-909a-3f261817b25e";
		String finalUrlTime = null;
		List<String> timeList = new ArrayList<>();

		List<String> busStopIdList = new ArrayList<>();
		try{

            Root root = objectMapper.readValue(new URL(finalUrl),Root.class);
            System.out.println(root.toString());

			for (Result result : root.getResults()) {
				System.out.println(result.toString());

				for (Value value : result.getValues()) {
					System.out.println(value.toString());
					value.getKey();
					if(value.getKey().equals("zespol")){
						busStopIdList.add(value.getValue());
					}
				}
			}

//            List<Result> resultList = new ArrayList<>();
//			for (int i = 0; i <root.getResults().size() ; i++) {
//				resultList.add(root.getResults().get(i));
//			}
//
//			for (Result result: resultList) {
//				System.out.println(result.toString());
//			}
//
//			List<Value> valueList = new ArrayList<>();
//			for (int i = 0; i <resultList.size() ; i++) {
//				valueList.add(resultList.get(i).getValues().get(i));
//			}
//
//			for (Value value: valueList) {
//				System.out.println(value.toString());
//			}
//			busStopId = (valueList.get(0).getValue());
			for (String busStop: busStopIdList) {
				finalUrl2 = lineList+busStop+lineList2;
				root = objectMapper.readValue(new URL(finalUrl2),Root.class);
				//System.out.println(root.toString());

				finalUrlTime = urlTime + busStop + urlTime1 + line + urlTime2;
				root = objectMapper.readValue(new URL(finalUrlTime),Root.class);
				//System.out.println(root.toString());


			}
			for (Result result : root.getResults()) {
				//System.out.println(result.toString());

				for (Value value : result.getValues()) {
					value.getKey();
					if(value.getKey().equals("czas")){
						timeList.add(value.getValue());
					}
				}
			}

			for (String time: timeList) {
				System.out.println(time);
			}
        }catch(IOException e){
		    e.printStackTrace();
        }
	}
}
