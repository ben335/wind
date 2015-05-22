package org.bg.wind.rawdatadownloader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String args[]){

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/application-context.xml");
    }
}
