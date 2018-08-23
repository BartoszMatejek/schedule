package com.ztm.schedule;

import com.ztm.schedule.implementation.GettingData;
import com.ztm.schedule.implementation.ZtmImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Scanner;

@SpringBootApplication
public class ScheduleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScheduleApplication.class, args);
	}

	@PostConstruct
	public void method() {

		Scanner scanner = new Scanner(System.in);
		ZtmImpl ztm = new ZtmImpl();
		GettingData gettingData = new GettingData();
		gettingData.setZtm(ztm);
		System.out.println("Podaj przystanek");
		String station = scanner.next();
		try {
			String encoded = URLEncoder.encode(station, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		gettingData.setStation(station);
		gettingData.createBusStopIdList();
		System.out.println("Podaj numer słupka");
		String busStopNumber = scanner.next();
		gettingData.setBusStopNumber(busStopNumber);
		gettingData.createLinesList();
		System.out.println(gettingData.getLinesList());
		for (String busStopId: gettingData.getBusStopIdList()) {
			System.out.println(busStopId);
		}
		
	}
}

