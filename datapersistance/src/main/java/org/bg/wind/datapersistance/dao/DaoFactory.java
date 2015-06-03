package org.bg.wind.datapersistance.dao;

public class DaoFactory {

    private WindReadingDao windReadingDao;

    public WindReadingDao getWindReadingDao() { return windReadingDao; }

    public void setWindReadingDao(WindReadingDao windReadingDao){this.windReadingDao = windReadingDao;}

}
