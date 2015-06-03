package org.bg.wind.datapersistance.dao;


import org.bg.wind.datapersistance.domain.WindReading;

public interface WindReadingDao {
    void addReading(WindReading windReading) throws RuntimeException;
    boolean existsByDateTime(WindReading windReading) throws RuntimeException;
}
