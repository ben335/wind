package org.bg.wind.webservice.domain;

import java.time.LocalDate;
import java.time.LocalTime;

public class WindReading {

    int readingId; //primary key
    LocalDate dateOfReading;
    LocalTime timeOfReading;
    int avg_twd;
    double avg_tws;


    public WindReading() {

    }

    public WindReading(int readingId, LocalDate dateOfReading, LocalTime timeOfReading, int avg_twd, double avg_tws) {
        this.readingId = readingId;
        this.dateOfReading = dateOfReading;
        this.timeOfReading = timeOfReading;
        this.avg_twd = avg_twd;
        this.avg_tws = avg_tws;
    }

    public int getReadingId() {
        return readingId;
    }

    public void setReadingId(int readingId) {
        this.readingId = readingId;
    }

    public LocalDate getDateOfReading() {
        return dateOfReading;
    }

    public void setDateOfReading(LocalDate dateOfReading) {
        this.dateOfReading = dateOfReading;
    }

    public LocalTime getTimeOfReading() {
        return timeOfReading;
    }

    public void setTimeOfReading(LocalTime timeOfReading) {
        this.timeOfReading = timeOfReading;
    }

    public int getAvg_twd() {
        return avg_twd;
    }

    public void setAvg_twd(int avg_twd) {
        this.avg_twd = avg_twd;
    }

    public double getAvg_tws() {
        return avg_tws;
    }

    public void setAvg_tws(double avg_tws) {
        this.avg_tws = avg_tws;
    }
}
