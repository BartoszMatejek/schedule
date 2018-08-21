package com.ztm.schedule;
import com.ztm.schedule.implementation.ZtmImpl;
import com.ztm.schedule.model.Result;
import com.ztm.schedule.model.Root;
import com.ztm.schedule.model.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class ScheduleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScheduleApplication.class, args);
	}

	@PostConstruct
	public void method() {
		List<String> busStopIdList = new ArrayList<>();
		List<String> lines = new ArrayList<>();
		List<String> times = new ArrayList<>();

		Scanner scanner = new Scanner(System.in);
		Object root = new Root();
		ZtmImpl ztm = new ZtmImpl();
		String myStation = scanner.next();
		String post = "01";
		String station = null;
		try{
			station = URLEncoder.encode(myStation,"UTF-8");
		}catch (UnsupportedEncodingException e){
			e.printStackTrace();
		}

		System.out.println(ztm.getBusStopId(station));
		for (Result result: ztm.getBusStopId(station).getResults()) {
			for(Value value: result.getValues()){
				if(value.getKey().equals("zespol")){
					busStopIdList.add(value.getValue());
				}
			}
		}

		for (String busStopId: busStopIdList) {
			System.out.println(ztm.getLines(busStopId,post));
		}

		for(String busStopId: busStopIdList){

		for (Result result: ztm.getLines(busStopId,post).getResults()) {
			for (Value value : result.getValues()) {
				if (value.getKey().equals("linia")) {
					lines.add(value.getValue());
				}
			}
		}
			for (String line: lines) {
				System.out.println(line);
			}
		}
		for(String busStopId: busStopIdList) {

			for (Result result : ztm.getTimes(busStopId, post,"1").getResults()) {
				for (Value value : result.getValues()) {
					if (value.getKey().equals("czas")) {
						times.add(value.getValue());
					}
				}
			}
		}

		for (String time: times) {
			System.out.println(time);
		}
	}
}

