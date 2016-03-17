/*
 * RowMapperFactory.java
 *
 * Created on November 23, 2006, 11:34 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.nob.bg.dao.jdbc;

import com.nob.bg.model.*;
import com.nob.bg.model.reports.DistToDate;
import com.nob.bg.model.reports.MonthlyStats;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author jorismelchior
 */
public class BikeGearsRowMappers {
    public static RowMapper<BikeRide> BIKE_RIDE_ROWMAPPER = new RowMapper<BikeRide>() {
        public BikeRide mapRow(ResultSet rs, int rowNum) throws SQLException {
            BikeRide ride = new BikeRide();
            ride.setAverageHr(rs.getInt("average_hr"));
            ride.setCaloriesBurnt(rs.getInt("calories_burnt"));
            ride.setDate(rs.getDate("date"));
            ride.setDistanceKm(rs.getFloat("distance_km"));
            ride.setFinishLocation(rs.getString("finish_location"));
            ride.setId(rs.getLong("id"));
            ride.setJournal(rs.getString("journal"));
            ride.setMaximumHr(rs.getInt("maximum_hr"));
            ride.setRideTimeSeconds(rs.getInt("ride_time_seconds"));
            ride.setStartLocation(rs.getString("start_location"));
            
            return ride;
        }
    };
    
    public static RowMapper<BikeRideType> BIKE_RIDE_TYPE_ROWMAPPER = new RowMapper<BikeRideType>() {
        public BikeRideType mapRow(ResultSet rs, int rowNum) throws SQLException {
            BikeRideType brType = new BikeRideType();
            brType.setId(rs.getLong("id"));
            brType.setName(rs.getString("name"));
            brType.setDescription(rs.getString("description"));
            
            return brType;
        }
    };
    
    public static RowMapper<BikeRider> BIKE_RIDER_ROWMAPPER = new RowMapper<BikeRider>() {
        public BikeRider mapRow(ResultSet rs, int rowNum) throws SQLException {
            BikeRider rider = new BikeRider();
            rider.setId(rs.getLong("id"));
            rider.setPassword(rs.getString("password"));
            rider.setUserName(rs.getString("user_name"));
            
            return rider;
        }
    };
    
    public static RowMapper<Bike> BIKE_ROWMAPPER = new RowMapper<Bike>() {
        public Bike mapRow(ResultSet rs, int rowNum) throws SQLException {
            Bike bike = new Bike();
            bike.setId(rs.getLong("id"));
            bike.setBrand(rs.getString("brand"));
            bike.setModel(rs.getString("model"));
            bike.setColor(rs.getString("color"));
            bike.setDescription(rs.getString("description"));
            bike.setYear(rs.getInt("year"));
            
            return bike;
        }
    };
    
    public static RowMapper<BikeType> BIKE_TYPE_ROWMAPPER = new RowMapper<BikeType>() {
        public BikeType mapRow(ResultSet rs, int rowNum) throws SQLException {
            BikeType bType = new BikeType();
            bType.setId(rs.getLong("id"));
            bType.setName(rs.getString("name"));
            bType.setDescription(rs.getString("description"));
            
            return bType;
        }
    };
    
    public static RowMapper<DistToDate> DIST_TO_DATE_ROWMAPPER = new RowMapper<DistToDate>() {
        public DistToDate mapRow(ResultSet rs, int rowNum) throws SQLException {
            DistToDate mStats = new DistToDate();
            mStats.setAvgDistance(rs.getFloat("Avg Dist"));
            mStats.setDayOfYear(rs.getInt("DOY"));
            mStats.setDistToDate(rs.getFloat("Dist to date"));
            mStats.setMaxDistance(rs.getFloat("Max Dist"));
            mStats.setNumOfRides(rs.getInt("# Rides"));
            mStats.setYear(rs.getInt("Year"));
            
            return mStats;
        }
    };
    
    public static RowMapper<MonthlyStats> MONTHLY_STATS_ROWMAPPER = new RowMapper<MonthlyStats>() {
        public MonthlyStats mapRow(ResultSet rs, int rowNum) throws SQLException {
            MonthlyStats mStats = new MonthlyStats();
            mStats.setAvgDistance(rs.getFloat("Avg Dist"));
            mStats.setDistance(rs.getFloat("Distance"));
            mStats.setMaxDistance(rs.getFloat("Max Dist"));
            mStats.setMonth(rs.getString("Month"));
            mStats.setNumRides(rs.getInt("Rides"));
            mStats.setYear(rs.getInt("Year"));
            
            return mStats;
        }
    };
    
    public static RowMapper<Person> PERSON_ROWMAPPER = new RowMapper<Person>() {
        public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
            Person person = new Person();
            person.setId(rs.getLong("id"));
            person.setFirstName(rs.getString("first_name"));
            person.setLastName(rs.getString("last_name"));
            person.setInitials(rs.getString("initials"));
            
            return person;
        }
    };
    
    /** Creates a new instance of RowMapperFactory */
    public BikeGearsRowMappers() {
    }
}
