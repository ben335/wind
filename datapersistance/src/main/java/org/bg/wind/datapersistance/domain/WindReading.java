package org.bg.wind.datapersistance.domain;

import java.time.LocalDate;
import java.time.LocalTime;

public class WindReading {

    int readingId; //primary key
    LocalDate dateOfReading;
    LocalTime timeOfReading;
    int back_twd;
    int avg_twd;
    int veer_twd;
    double min_tws;
    double avg_tws;
    double max_tws;
    int sampleSize;
    int stationId; //foreign key

    public WindReading() {
    }

    public WindReading(int readingId, LocalDate dateOfReading, LocalTime timeOfReading, int back_twd, int avg_twd, int veer_twd, double min_tws, double avg_tws, double max_tws, int sampleSize, int stationId) {
        this.readingId = readingId;
        this.dateOfReading = dateOfReading;
        this.timeOfReading = timeOfReading;
        this.back_twd = back_twd;
        this.avg_twd = avg_twd;
        this.veer_twd = veer_twd;
        this.min_tws = min_tws;
        this.avg_tws = avg_tws;
        this.max_tws = max_tws;
        this.sampleSize = sampleSize;
        this.stationId = stationId;
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

    public int getBack_twd() {
        return back_twd;
    }

    public void setBack_twd(int back_twd) {
        this.back_twd = back_twd;
    }

    public int getAvg_twd() {
        return avg_twd;
    }

    public void setAvg_twd(int avg_twd) {
        this.avg_twd = avg_twd;
    }

    public int getVeer_twd() {
        return veer_twd;
    }

    public void setVeer_twd(int veer_twd) {
        this.veer_twd = veer_twd;
    }

    public double getMin_tws() {
        return min_tws;
    }

    public void setMin_tws(double min_tws) {
        this.min_tws = min_tws;
    }

    public double getAvg_tws() {
        return avg_tws;
    }

    public void setAvg_tws(double avg_tws) {
        this.avg_tws = avg_tws;
    }

    public double getMax_tws() {
        return max_tws;
    }

    public void setMax_tws(double max_tws) {
        this.max_tws = max_tws;
    }

    public int getSampleSize() {
        return sampleSize;
    }

    public void setSampleSize(int sampleSize) {
        this.sampleSize = sampleSize;
    }

    public int getStationId() {
        return stationId;
    }

    public void setStationId(int stationId) {
        this.stationId = stationId;
    }
}
