package org.bg.wind.datapersistance.dao;

import org.bg.wind.datapersistance.domain.WindReading;
import org.bg.wind.datapersistance.util.ObjectUtility;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class WindReadingDaoImpl extends HibernateDaoSupport implements WindReadingDao {

    public void addReading(WindReading windReading) throws RuntimeException {
        try {
            getSessionFactory().getCurrentSession().saveOrUpdate(windReading);
            getSessionFactory().getCurrentSession().flush();
            getSessionFactory().getCurrentSession().clear();
        } catch (RuntimeException e) {
            logger.error("Exception when adding record to the database from the DAO: ", e);
            throw e;
        }
    }

    public boolean existsByDateTime (WindReading windReading) {
        Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(WindReading.class);
        criteria.add(Restrictions.eq("date", windReading.getDateOfReading()));
        criteria.add(Restrictions.eq("time", windReading.getTimeOfReading()));
        criteria.add(Restrictions.eq("stationId", windReading.getStationId()));
        //TODO check station id to ensure that the reading exists for the correct station
        List<WindReading> readings = criteria.list();
        if (readings.isEmpty()){
            logger.info("No previous same readings found");
            return false;
        }else {
            logger.info("Previous same reading found for station: " + windReading.getStationId() + " in reading: " + ObjectUtility.printReading(windReading));
            return true;
        }

    }
}
