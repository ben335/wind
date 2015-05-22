package org.bg.wind.rawdatadownloader;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Transactional
public class Downloader {

    //every five minutes
    @Scheduled(cron="0 0/5 * * * ?")
    public void downloadLatestFiles(){
        List<String> locations = new ArrayList<String>();
        locations.add("lymington");
        locations.add("hurst");
        locations.add("yarmouth");
        locations.add("highcliffe");
        locations.add("portland");

        for (String location : locations) {
            String urlPrefix = "http://www.weather-file.com/" + location + "/data/";
            String urlPostFix = ".csv";
            String fullUrl = "";

            LocalDate currentDate = LocalDate.now();

            StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append(String.format("%04d", currentDate.getYear()));
            sb.append(String.format("%02d", currentDate.getMonthValue()));
            sb.append(String.format("%02d", currentDate.getDayOfMonth()));
            String filedate = sb.toString();

            fullUrl = urlPrefix + filedate + urlPostFix;

            String command = "wget -N -P ./data/" + location + " " + fullUrl;
            downloadFiles(command);

            System.out.println(fullUrl);
            System.out.println("wget executed at above url. Current time is :: " + new Date());
        }

    }


    public void downloadAllforLocation(){

        List<String> locations = new ArrayList<String>();
        locations.add("lymington");
        locations.add("hurst");
        locations.add("yarmouth");
        locations.add("highcliffe");
        locations.add("portland");

        for (String location : locations) {

            String urlPrefix = "http://www.weather-file.com/" + location + "/data/";
            String urlPostFix = ".csv";
            String fullUrl = "";

            LocalDate currentDate = LocalDate.now();

            for (int year = 2008; year < currentDate.getYear() + 1; year++) {
                for (int month = 01; month < 13; month++) {
                    for (int day = 01; day < 32; day++) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("");
                        sb.append(String.format("%04d", year));
                        sb.append(String.format("%02d", month));
                        sb.append(String.format("%02d", day));
                        String filedate = sb.toString();

                        fullUrl = urlPrefix + filedate + urlPostFix;

                        String command = "wget -N -P ./data/" + location + " " + fullUrl;
                        //downloadFiles(command);

                        System.out.println(fullUrl);

                    }
                }
            }
        }
    }

    public void downloadFiles(String command){
        try
        {
            Runtime rt = Runtime.getRuntime();
            Process proc = rt.exec(command);
            int exitVal = proc.waitFor();
            System.out.println("Process exitValue:" + exitVal);
        } catch (Throwable t)
        {
            t.printStackTrace();
        }
    }



}
