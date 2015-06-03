package org.bg.wind.datapersistance.util;

import org.bg.wind.datapersistance.domain.WindReading;
import java.util.ArrayList;

public class ObjectUtility {

    public static void printAllReadings(ArrayList<WindReading> listOfReadings) {
        System.out.println("Reading ID" + "\t" + "Date" + "\t" + "Time" + "\t" + "back_twd" + "\t" + "avg_twd" + "\t" + "veer_twd" + "\t" + "min_tws" + "\t" + "avg_tws" + "\t" + "max_tws" + "\t" + "sampleSize" + "\t" + "Station ID");
        System.out.println();
        for (WindReading wind : listOfReadings){
            System.out.println(wind.getReadingId() + "\t" + wind.getDateOfReading() + "\t" + wind.getTimeOfReading() + "\t" + wind.getBack_twd() + "\t" + wind.getAvg_twd() + "\t" + wind.getVeer_twd() + "\t" + wind.getMin_tws() + "\t" + wind.getAvg_tws() + "\t" + wind.getMax_tws() + "\t" + wind.getSampleSize() + "\t" + wind.getStationId());
        }
    }

    public static String printReading(WindReading windReading) {
         return ("Reading ID: " + windReading.getReadingId() + "Date: " + windReading.getDateOfReading() + "Time: " + windReading.getTimeOfReading() + " back_twd: " + windReading.getBack_twd() + " avg_twd: " + windReading.getAvg_twd() + " veer_twd: " + windReading.getVeer_twd() + " min_tws: " + windReading.getMin_tws() + " avg_tws: " + windReading.getAvg_tws() + " max_tws: " + windReading.getMax_tws() + " sampleSize: " + windReading.getSampleSize() + " Station ID: " + windReading.getStationId());

    }
}