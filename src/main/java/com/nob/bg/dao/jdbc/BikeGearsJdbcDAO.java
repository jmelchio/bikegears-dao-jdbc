/*
 * BikeGearsJdbcDAO.java
 *
 * Created on August 1, 2006, 7:53 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.nob.bg.dao.jdbc;

import com.nob.bg.dao.BikeGearsDAO;
import com.nob.bg.model.*;
import com.nob.bg.model.dto.LoginDTO;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

/**
 * 
 * @author jorismelchior
 */
public class BikeGearsJdbcDAO extends JdbcDaoSupport implements BikeGearsDAO {

    /** Creates a new instance of BikeGearsJdbcDAO */
    public BikeGearsJdbcDAO() {
    }

    public BikeRider login(LoginDTO login) {
        JdbcTemplate jt = new JdbcTemplate(this.getDataSource());
        Object[] args = { login.getUserName(), login.getPassword() };
        return jt.queryForObject(
                "select * from bike_rider where user_name=? and password=?",
                BikeGearsRowMappers.BIKE_RIDER_ROWMAPPER, args);
    }

    public Bike createBike(Bike bike) {
        JdbcTemplate jt = new JdbcTemplate(this.getDataSource());
        Object[] args = { bike.getBikeRider().getId(), bike.getBrand(),
                bike.getColor(), bike.getDescription(), bike.getModel(),
                bike.getBikeType().getId(), bike.getYear() };
        jt.update("insert into bike (bike_rider_id, brand, color, description, model"
                + ", type_id, year) values (?, ?, ?, ?, ?, ?, ?)", args);
        return null;
    }

    public void changeBike(Bike bike) {
        JdbcTemplate jt = new JdbcTemplate(this.getDataSource());
        Object[] args = { bike.getBikeRider().getId(), bike.getBrand(),
                bike.getColor(), bike.getDescription(), bike.getModel(),
                bike.getBikeType().getId(), bike.getYear(), bike.getId() };
        jt.update("update bike set bike_rider_id = ?, brand = ?, color = ?, description = ?"
                + ", model = ?, type_id = ?, year = ? where id = ?", args);
    }

    public Bike getBikeById(Long id) {
        JdbcTemplate jt = new JdbcTemplate(this.getDataSource());
        Object[] args = { id };
        return jt.queryForObject("select * from bike where id = ?",
                BikeGearsRowMappers.BIKE_ROWMAPPER, args);
    }

    public void deleteBike(Bike bike) {
        this.deleteBikeById(bike.getId());
    }

    public void deleteBikeById(Long id) {
        JdbcTemplate jt = new JdbcTemplate(this.getDataSource());
        Object[] args = { id };
        jt.update("delete from bike where id = ?", args);
    }

    public List<Bike> getBikes() {
        JdbcTemplate jt = new JdbcTemplate(this.getDataSource());
        return jt.query("select * from bike", BikeGearsRowMappers.BIKE_ROWMAPPER);
    }

    public List<Bike> getBikesForRider(BikeRider rider) {
        return this.getBikesForRiderById(rider.getId());
    }

    public BikeRide createBikeRide(BikeRide ride) {
        JdbcTemplate jt = new JdbcTemplate(this.getDataSource());
        Object[] args = { ride.getAverageHr(), ride.getBike().getId(),
                ride.getBikeRider().getId(), ride.getCaloriesBurnt(),
                ride.getDate(), ride.getDistanceKm(), ride.getFinishLocation(),
                ride.getJournal(), ride.getMaximumHr(),
                ride.getRideTimeSeconds(), ride.getStartLocation(),
                ride.getBikeRideType().getId() };
        jt.update("insert into bike_ride (average_hr, bike_id, bike_rider_id, "
                + "calories_burnt, date, distance_km, finish_location, journal,"
                + " maximum_hr, ride_time_seconds, start_location, type_id) "
                + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", args);
        return null;
    }

    public void changeBikeRide(BikeRide ride) {
        JdbcTemplate jt = new JdbcTemplate(this.getDataSource());
        Object[] args = { ride.getAverageHr(), ride.getBike().getId(),
                ride.getBikeRider().getId(), ride.getCaloriesBurnt(),
                ride.getDate(), ride.getDistanceKm(), ride.getFinishLocation(),
                ride.getJournal(), ride.getMaximumHr(),
                ride.getRideTimeSeconds(), ride.getStartLocation(),
                ride.getBikeRideType().getId(), ride.getId() };
        jt.update("update bike_ride set average_hr = ?, bike_id = ?, bike_rider_id = ?, "
                + "calories_burnt = ?, date = ?, distance_km = ?, finish_location = ?, journal = ?,"
                + " maximum_hr = ?, ride_time_seconds = ?, start_location = ?, type_id = ? "
                + "where id = ?", args);
    }

    public BikeRide getBikeRideById(Long id) {
        JdbcTemplate jt = new JdbcTemplate(this.getDataSource());
        Object[] args = { id };
        return jt.queryForObject("select * from bike_ride where id = ?",
                BikeGearsRowMappers.BIKE_RIDE_ROWMAPPER, args);
    }

    public void deleteBikeRide(BikeRide ride) {
        this.deleteBikeRideById(ride.getId());
    }

    public void deleteBikeRideById(Long id) {
        JdbcTemplate jt = new JdbcTemplate(this.getDataSource());
        Object[] args = { id };
        jt.update("delete from bike_ride where id = ?", args);
    }

    @SuppressWarnings("unchecked")
    public List<BikeRide> getBikeRides(Integer rowLimit) {
        JdbcTemplate jt = new JdbcTemplate(this.getDataSource());
        if (rowLimit != null) {
            jt.setFetchSize(rowLimit);
        }
        return jt.query("select * from bike_ride",
                BikeGearsRowMappers.BIKE_RIDE_ROWMAPPER);
    }

    public List<BikeRide> getBikeRidesForRider(BikeRider rider, Integer rowLimit) {
        return this.getBikeRidesForRiderById(rider.getId(), rowLimit);
    }

    public BikeRideType createBikeRideType(BikeRideType rideType) {
        JdbcTemplate jt = new JdbcTemplate(this.getDataSource());
        Object[] args = { rideType.getName(), rideType.getDescription() };
        jt.update("insert into bike_ride_type (name, description) values (?, ?)"
                , args);
        return null;
    }

    public void changeBikeRideType(BikeRideType rideType) {
        JdbcTemplate jt = new JdbcTemplate(this.getDataSource());
        Object[] args = { rideType.getName(), rideType.getDescription(),
                rideType.getId() };
        jt.update("update bike_ride_type set name = ?, description = ? where id = ?"
                , args);
    }

    public BikeRideType getBikeRideTypeById(Long id) {
        JdbcTemplate jt = new JdbcTemplate(this.getDataSource());
        Object[] args = { id };
        List<BikeRideType> results = jt.query(
                "select * from bike_ride_type where id = ?",
                BikeGearsRowMappers.BIKE_RIDE_TYPE_ROWMAPPER, args);
        if (results != null && results.size() > 0) {
            return results.get(0);
        } else {
            return null;
        }
    }

    public void deleteBikeRideType(BikeRideType rideType) {
        this.deleteBikeRideTypeById(rideType.getId());
    }

    public void deleteBikeRideTypeById(Long id) {
        JdbcTemplate jt = new JdbcTemplate(this.getDataSource());
        Object[] args = { id };
        jt.update("delete from bike_ride_type where id = ?", args);
    }

    public List<BikeRideType> getBikeRideTypes() {
        JdbcTemplate jt = new JdbcTemplate(this.getDataSource());
        return jt.query("select * from bike_ride_type",
                BikeGearsRowMappers.BIKE_RIDE_TYPE_ROWMAPPER);
    }

    public BikeRider createBikeRider(BikeRider rider) {
        JdbcTemplate jt = new JdbcTemplate(this.getDataSource());
        Object[] args = { rider.getPassword(), rider.getUserName(),
                rider.getPerson().getId() };
        jt.update("insert into bike_rider (password, user_name, person_id) values (?, ?, ?)"
                , args);
        return null;
    }

    public void changeBikeRider(BikeRider rider) {
        JdbcTemplate jt = new JdbcTemplate(this.getDataSource());
        Object[] args = { rider.getPassword(), rider.getUserName(),
                rider.getPerson().getId(), rider.getId() };
        jt.update("update bike_rider set password = ?, user_name = ?, person_id = ? where user_id = ?"
                , args);
    }

    public BikeRider getBikeRiderById(Long id) {
        JdbcTemplate jt = new JdbcTemplate(this.getDataSource());
        Object[] args = { id };
        return jt.queryForObject("select * from bike_rider where id = ?",
                BikeGearsRowMappers.BIKE_RIDER_ROWMAPPER, args);
    }

    public void deleteBikeRider(BikeRider rider) {
        this.deleteBikeRiderById(rider.getId());
    }

    public void deleteBikeRiderById(Long id) {
        JdbcTemplate jt = new JdbcTemplate(this.getDataSource());
        Object[] args = { id };
        jt.update("delete from bike_rider where id = ?", args);
    }

    public List<BikeRider> getBikeRiders() {
        JdbcTemplate jt = new JdbcTemplate(this.getDataSource());
        return jt.query("select * from bike_rider",
                BikeGearsRowMappers.BIKE_RIDER_ROWMAPPER);
    }

    public BikeType createBikeType(BikeType bikeType) {
        JdbcTemplate jt = new JdbcTemplate(this.getDataSource());
        Object[] args = { bikeType.getName(), bikeType.getDescription() };
        jt.update("insert into bike_type (name, description) values (?, ?)",
                args);
        return null;
    }

    public void changeBikeType(BikeType bikeType) {
        JdbcTemplate jt = new JdbcTemplate(this.getDataSource());
        Object[] args = { bikeType.getName(), bikeType.getDescription(),
                bikeType.getId() };
        jt.update("update bike_type set name = ?, description = ? where id = ?"
                , args);
    }

    public BikeType getBikeTypeById(Long id) {
        JdbcTemplate jt = new JdbcTemplate(this.getDataSource());
        Object[] args = { id };
        List<BikeType> results = jt.query(
                "select * from bike_type where id = ?",
                BikeGearsRowMappers.BIKE_TYPE_ROWMAPPER, args);
        if (results != null && results.size() > 0) {
            return results.get(0);
        } else {
            return null;
        }
    }

    public void deleteBikeType(BikeType bikeType) {
        this.deleteBikeTypeById(bikeType.getId());
    }

    public void deleteBikeTypeById(Long id) {
        JdbcTemplate jt = new JdbcTemplate(this.getDataSource());
        Object[] args = { id };
        jt.update("delete from bike_ride where id = ?", args);
    }

    public List<BikeType> getBikeTypes() {
        JdbcTemplate jt = new JdbcTemplate(this.getDataSource());
        return jt.query("select * from bike_type",
                BikeGearsRowMappers.BIKE_TYPE_ROWMAPPER);
    }

    public Person createPerson(Person person) {
        JdbcTemplate jt = new JdbcTemplate(this.getDataSource());
        Object[] args = { person.getFirstName(), person.getLastName(),
                person.getInitials(), person.getBirthdate() };
        jt.update("insert into person (first_name, last_name, initials, birth_date) values (?, ?, ?, ?)"
                , args);
        return null;
    }

    public Person getPersonById(Long id) {
        JdbcTemplate jt = new JdbcTemplate(this.getDataSource());
        Object[] args = { id };
        return jt.queryForObject("select * from person where id = ?",
                BikeGearsRowMappers.PERSON_ROWMAPPER, args);
    }

    public void changePerson(Person person) {
        JdbcTemplate jt = new JdbcTemplate(this.getDataSource());
        Object[] args = { person.getFirstName(), person.getLastName(),
                person.getInitials(), person.getBirthdate(), person.getId() };
        jt.update("update person set first_name = ?, last_name = ?, initials = ?, birth_date = ? where id = ?"
                , args);
    }

    public List<Person> getPeople() {
        JdbcTemplate jt = new JdbcTemplate(this.getDataSource());
        return jt.query("select * from person", BikeGearsRowMappers.PERSON_ROWMAPPER);
    }

    public void deletePerson(Person person) {
        this.deletePersonById(person.getId());
    }

    public void deletePersonById(Long id) {
        JdbcTemplate jt = new JdbcTemplate(this.getDataSource());
        Object[] args = { id };
        jt.update("delete person where id = ?", args);
    }

    public List<Bike> getBikesForRiderById(Long bikeRiderId) {
        JdbcTemplate jt = new JdbcTemplate(this.getDataSource());
        Object[] args = { bikeRiderId };
        return jt.query("select * from bike where bike_rider_id = ?",
                BikeGearsRowMappers.BIKE_ROWMAPPER, args);
    }

    @SuppressWarnings("unchecked")
    public List<BikeRide> getBikeRidesForRiderById(Long bikeRiderId,
            Integer rowLimit) {
        JdbcTemplate jt = new JdbcTemplate(this.getDataSource());
        if (rowLimit != null) {
            jt.setFetchSize(rowLimit);
        }
        Object[] args = { bikeRiderId };
        return jt.query("select * from bike_ride where bike_rider_id = ?",
                args, BikeGearsRowMappers.BIKE_RIDE_ROWMAPPER);
    }

    public Bike getBikeForRide(BikeRide ride) {
        // TODO Auto-generated method stub
        return null;
    }

    public BikeRideType getBikeRideTypeForRide(BikeRide ride) {
        // TODO Auto-generated method stub
        return null;
    }

    public BikeType getBikeTypeForBike(Bike bike) {
        // TODO Auto-generated method stub
        return null;
    }

    public Person getPersonForBikeRider(BikeRider rider) {
        JdbcTemplate jt = new JdbcTemplate(this.getDataSource());
        Object[] args = { rider.getId() };
        Long id = jt.queryForObject(
                "select person_id from bike_rider where id = ?", args, Long.class);
        Object[] args1 = { id };
        try {
            return jt.queryForObject("select * from person where id = ?",
                    BikeGearsRowMappers.PERSON_ROWMAPPER, args1);
        } catch (DataAccessException dae) {
            return null;
        }
    }

    public BikeRider getBikeRiderForBikeRide(BikeRide ride) {
        // TODO Auto-generated method stub
        return null;
    }

}
/* That's All Folks */