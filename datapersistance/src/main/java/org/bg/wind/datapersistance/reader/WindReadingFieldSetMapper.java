package org.bg.wind.datapersistance.reader;

import org.bg.wind.datapersistance.domain.WindReading;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.BindException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
/**
 * Builds a Wind Reading from a row in the CSV file (as a set of fields)
 */
public class WindReadingFieldSetMapper implements FieldSetMapper<WindReading> {

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate localDate;

    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalTime localTime;

    @Override
    public WindReading mapFieldSet(FieldSet fieldSet) throws BindException {
        WindReading windReading = new WindReading();

        Date dateInput = fieldSet.readDate("date");
        localDate = dateInput.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        Date timeInput = fieldSet.readDate("time");
        localTime = timeInput.toInstant().atZone(ZoneId.systemDefault()).toLocalTime();

        windReading.setDateOfReading(localDate);
        windReading.setTimeOfReading(localTime);
        windReading.setBack_twd(fieldSet.readInt("back_twd"));
        windReading.setAvg_twd(fieldSet.readInt("avg_twd"));
        windReading.setVeer_twd(fieldSet.readInt("veer_twd"));
        windReading.setMin_tws(fieldSet.readDouble("min_tws"));
        windReading.setAvg_tws(fieldSet.readDouble("avg_tws"));
        windReading.setMax_tws(fieldSet.readDouble("max_tws"));
        windReading.setSampleSize(fieldSet.readInt("sampleSize"));
        return windReading;
    }
}