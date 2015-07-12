package org.bg.wind.webservice.service;

import org.bg.wind.webservice.domain.WindReading;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Hard coded simulation of a Service + Data Access Layer.
 */
@Service
public class WindService {

	private Map<String, WindReading> windReadingMap;

	/**
	 * Constructor populates the 'database' (i.e. Maps) of Artists and Albums.
	 */
	public WindService() {

		windReadingMap = new HashMap<String, WindReading>();


		//READING 1

		String date = "2015/01/01";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate localDate = LocalDate.parse(date, formatter);

		String time = "15:00.00";
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm.ss");
		LocalTime localTime = LocalTime.parse(time, timeFormatter);

		int direction = 200;
		int windspeed = 15;

		WindReading windReading1 = new WindReading(1,localDate, localTime, direction, windspeed);
		windReadingMap.put(Integer.toString(windReading1.getReadingId()), windReading1);

		//READING2

		String date2 = "2015/01/01";
		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate localDate2 = LocalDate.parse(date, formatter2);

		String time2 = "16:00.00";
		DateTimeFormatter timeFormatter2 = DateTimeFormatter.ofPattern("HH:mm.ss");
		LocalTime localTime2 = LocalTime.parse(time, timeFormatter2);

		int direction2 = 300;
		int windspeed2 = 20;

		WindReading windReading2 = new WindReading(2,localDate2, localTime2, direction2, windspeed2);
		windReadingMap.put(Integer.toString(windReading2.getReadingId()), windReading2);
		
	}

	public Collection<WindReading> getAllWindData() {
		return windReadingMap.values();
	}

	public WindReading getWindReading(final String id) {
		return windReadingMap.get(id);
	}

}