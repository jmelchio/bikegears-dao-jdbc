/**
 * 
 */
package com.nob.bg.dao.jdbc;

import com.nob.bg.dao.BikeGearsReportDAO;
import com.nob.bg.model.BikeRider;
import com.nob.bg.model.reports.DistToDate;
import com.nob.bg.model.reports.MonthlyStats;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

/**
 * @author jorismelchior
 *
 */
public class BikeGearsReportJdbcDAO extends JdbcDaoSupport implements BikeGearsReportDAO {
    
    public List<DistToDate> getDistToDateForBikeRider(BikeRider bikeRider) {
        return getDistToDateForBikeRiderById(bikeRider.getId());
    }

    public List<MonthlyStats> getMonthlyStatsForBikeRider(BikeRider bikeRider) {
        return getMonthlyStatsForBikeRiderById(bikeRider.getId());
    }

    public List<MonthlyStats> getMonthComparisonForBikeRider(BikeRider bikeRider) {
        return getMonthComparisonForBikeRiderById(bikeRider.getId());
    }

    public List<DistToDate> getDistToDateForBikeRiderById(Long id) {
        JdbcTemplate jt = new JdbcTemplate(this.getDataSource());
        Object[] args = { id };
        return jt
                .query(
                        "select year(date) 'Year',  sum(distance_km) 'Dist to date'"
                                + ", avg(distance_km) 'Avg dist', max(distance_km) 'Max dist'"
                                + ", count(*) '# Rides', dayofyear(curdate()) 'DOY' from bike_ride"
                                + " where bike_rider_id = ? and dayofyear(date) <= dayofyear(curdate())"
                                + " and year(date) <= year(curdate()) group by year(date)",
                        BikeGearsRowMappers.DIST_TO_DATE_ROWMAPPER, args);
    }

    public List<MonthlyStats> getMonthlyStatsForBikeRiderById(Long id) {
        JdbcTemplate jt = new JdbcTemplate(this.getDataSource());
        Object[] args = { id };
        return jt
                .query(
                        "select monthname(date) 'Month', year(date) Year, sum(distance_km) 'Distance'"
                                + ", avg(distance_km) 'Avg Dist', max(distance_km) 'Max Dist', count(*) Rides "
                                + " from bike_ride where bike_rider_id = ? group by year(date), month(date) "
                                + " order by year(date), month(date)",
                        BikeGearsRowMappers.MONTHLY_STATS_ROWMAPPER, args);
    }

    public List<MonthlyStats> getMonthComparisonForBikeRiderById(Long id) {
        JdbcTemplate jt = new JdbcTemplate(this.getDataSource());
        Object[] args = { id };
        return jt
                .query(
                        "select monthname(date) 'Month', year(date) Year, sum(distance_km) 'Distance'"
                                + ", avg(distance_km) 'Avg Dist', max(distance_km) 'Max Dist', count(*) Rides "
                                + " from bike_ride where bike_rider_id = ? and month(date) = month(curdate()) "
                                + " and dayofmonth(date) <= dayofmonth(curdate()) group by year(date), month(date) "
                                + " order by year(date), month(date)",
                        BikeGearsRowMappers.MONTHLY_STATS_ROWMAPPER, args);
    }

}

// That's All Folks !!
