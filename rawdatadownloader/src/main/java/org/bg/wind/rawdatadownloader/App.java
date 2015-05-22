package org.bg.wind.rawdatadownloader;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    final static Logger logger = Logger.getLogger(App.class);

    public static void main(String args[]){
        logger.info("RAW DATA DOWNLOADER APPLICATION STARTING");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/application-context.xml");
    }
}
