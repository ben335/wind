package org.bg.wind.rawdatadownloader;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    final static Logger logger = Logger.getLogger(App.class);

    public static void main(String args[]){

        String argument = "";

        if (args.length > 0) {
             argument = (args[0]);
        } else {
            System.err.println("Arguments required, see usage document");
            System.exit(1);
        }

        if (argument.equals("downloadLatestFiles")){
            logger.info("ARGUMENT = downloadLatestFiles");
            logger.info("RAW DATA DOWNLOADER APPLICATION STARTING -- downloadLatestFiles");
            ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/downloadLatestFiles-application-context.xml");
        } else if (argument.equals("downloadAllFiles")){
            logger.info("ARGUMENT = downloadAllFiles");
            logger.info("RAW DATA DOWNLOADER APPLICATION STARTING -- downloadAllFiles");
            ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/downloadAllFiles-application-context.xml");
        }


    }
}
