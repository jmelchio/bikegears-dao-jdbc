package com.nob.bg.dao.jdbc;

import com.nob.bg.dao.BikeGearsDAO;
import com.nob.bg.model.BikeRider;
import com.nob.bg.model.Person;
import com.nob.bg.model.dto.LoginDTO;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by jmelchio on 22/03/16.
 *
 * Testing the jdbc implementation of the DAO.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:conf/spring/bikegears-core-jdbc-config.xml" })
public class BikeGearsJdbcDAOTest {
    private static String NOT_YET = "No testcase ready yet";

    @Autowired
    private BikeGearsDAO dao;

    @BeforeClass
    public static void prepareTest() {
        System.out.println("Prepare for full test...");
    }

    @AfterClass
    public static void pullDownTest() {
        System.out.println("Pull down after testing is done");
    }

    @Test
    public void testLogin() {
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setUserName("testUser");
        loginDTO.setPassword("testPassword");
        BikeRider testRider;
        Exception ex = null;
        try {
            testRider = dao.login(loginDTO);
        } catch(EmptyResultDataAccessException erEx) {
            ex = erEx;
        }
        assertNotNull("Expected exception", ex);
        Person testPerson = new Person();
        testPerson.setId((long) 42);

        BikeRider newRider = new BikeRider();
        newRider.setUserName("testUser");
        newRider.setPassword("testPassword");
        newRider.setPerson(testPerson);
        dao.createBikeRider(newRider);

        testRider = dao.login(loginDTO);
        assertNotNull("Expected bikeRider", testRider);

        dao.deleteBikeRider(testRider);
    }

    @Test
    public void shouldCreateBike() {
        assertNotNull(BikeGearsJdbcDAOTest.NOT_YET, null);
    }

    @Test
    public void shouldChangeBike() {
        assertNotNull(BikeGearsJdbcDAOTest.NOT_YET, null);
    }

    @Test
    public void shouldGetBikeById() {
        assertNotNull(BikeGearsJdbcDAOTest.NOT_YET, null);
    }

    @Test
    public void shouldDeleteBike() {
        assertNotNull(BikeGearsJdbcDAOTest.NOT_YET, null);
    }

    @Test
    public void shouldDeleteBikeById() {
        assertNotNull(BikeGearsJdbcDAOTest.NOT_YET, null);
    }

    @Test
    public void shouldGetBikes() {
        assertNotNull(BikeGearsJdbcDAOTest.NOT_YET, null);
    }

    @Test
    public void shouldGetBikesForRider() {
        assertNotNull(BikeGearsJdbcDAOTest.NOT_YET, null);
    }

    @Test
    public void shouldCreateBikeRide() {
        assertNotNull(BikeGearsJdbcDAOTest.NOT_YET, null);
    }

    @Test
    public void shouldChangeBikeRide() {
        assertNotNull(BikeGearsJdbcDAOTest.NOT_YET, null);
    }

    @Test
    public void shouldGetBikeRideById() {
        assertNotNull(BikeGearsJdbcDAOTest.NOT_YET, null);
    }

    @Test
    public void shouldDeleteBikeRide() {
        assertNotNull(BikeGearsJdbcDAOTest.NOT_YET, null);
    }

    @Test
    public void shouldDeleteBikeRideById() {
        assertNotNull(BikeGearsJdbcDAOTest.NOT_YET, null);
    }

    @Test
    public void shouldGetBikeRides() {
        assertNotNull(BikeGearsJdbcDAOTest.NOT_YET, null);
    }

    @Test
    public void shouldGetBikeRidesForRider() {
        assertNotNull(BikeGearsJdbcDAOTest.NOT_YET, null);
    }

    @Test
    public void shouldCreateBikeRideType() {
        assertNotNull(BikeGearsJdbcDAOTest.NOT_YET, null);
    }

    @Test
    public void shouldChangeBikeRideType() {
        assertNotNull(BikeGearsJdbcDAOTest.NOT_YET, null);
    }

    @Test
    public void shouldGetBikeRideTypeById() {
        assertNotNull(BikeGearsJdbcDAOTest.NOT_YET, null);
    }

    @Test
    public void shouldDeleteBikeRideType() {
        assertNotNull(BikeGearsJdbcDAOTest.NOT_YET, null);
    }

    @Test
    public void shouldDeleteBikeRideTypeById() {
        assertNotNull(BikeGearsJdbcDAOTest.NOT_YET, null);
    }

    @Test
    public void shouldGetBikeRideTypes() {
        assertNotNull(BikeGearsJdbcDAOTest.NOT_YET, null);
    }

    @Test
    public void shouldCreateBikeRider() {
        assertNotNull(BikeGearsJdbcDAOTest.NOT_YET, null);
    }

    @Test
    public void shouldChangeBikeRider() {
        assertNotNull(BikeGearsJdbcDAOTest.NOT_YET, null);
    }

    @Test
    public void shouldGetBikeRiderById() {
        assertNotNull(BikeGearsJdbcDAOTest.NOT_YET, null);
    }

    @Test
    public void shouldDeleteBikeRider() {
        assertNotNull(BikeGearsJdbcDAOTest.NOT_YET, null);
    }

    @Test
    public void shouldDeleteBikeRiderById() {
        assertNotNull(BikeGearsJdbcDAOTest.NOT_YET, null);
    }

    @Test
    public void shouldGetBikeRiders() {
        assertNotNull(BikeGearsJdbcDAOTest.NOT_YET, null);
    }

    @Test
    public void shouldCreateBikeType() {
        assertNotNull(BikeGearsJdbcDAOTest.NOT_YET, null);
    }

    @Test
    public void shouldChangeBikeType() {
        assertNotNull(BikeGearsJdbcDAOTest.NOT_YET, null);
    }

    @Test
    public void shouldGetBikeTypeById() {
        assertNotNull(BikeGearsJdbcDAOTest.NOT_YET, null);
    }

    @Test
    public void shouldDeleteBikeType() {
        assertNotNull(BikeGearsJdbcDAOTest.NOT_YET, null);
    }

    @Test
    public void shouldDeleteBikeTypeById() {
        assertNotNull(BikeGearsJdbcDAOTest.NOT_YET, null);
    }

    @Test
    public void shouldGetBikeTypes() {
        assertNotNull(BikeGearsJdbcDAOTest.NOT_YET, null);
    }

    @Test
    public void shouldCreatePerson() {
        assertNotNull(BikeGearsJdbcDAOTest.NOT_YET, null);
    }

    @Test
    public void shouldGetPersonById() {
        assertNotNull(BikeGearsJdbcDAOTest.NOT_YET, null);
    }

    @Test
    public void shouldChangePerson() {
        assertNotNull(BikeGearsJdbcDAOTest.NOT_YET, null);
    }

    @Test
    public void shouldGetPeople() {
        assertNotNull(BikeGearsJdbcDAOTest.NOT_YET, null);
    }

    @Test
    public void shouldDeletePerson() {
        assertNotNull(BikeGearsJdbcDAOTest.NOT_YET, null);
    }

    @Test
    public void shouldDeletePersonById() {
        assertNotNull(BikeGearsJdbcDAOTest.NOT_YET, null);
    }

    @Test
    public void shouldGetBikesForRiderById() {
        assertNotNull(BikeGearsJdbcDAOTest.NOT_YET, null);
    }

    @Test
    public void shouldGetBikeForRide() {
        assertNotNull(BikeGearsJdbcDAOTest.NOT_YET, null);
    }

    @Test
    public void shouldGetBikeRideTypeForRide() {
        assertNotNull(BikeGearsJdbcDAOTest.NOT_YET, null);
    }

    @Test
    public void shouldGetBikeTypeForBike() {
        assertNotNull(BikeGearsJdbcDAOTest.NOT_YET, null);
    }

    @Test
    public void shouldGetPersonForBikeRider() {
        assertNotNull(BikeGearsJdbcDAOTest.NOT_YET, null);
    }

    @Test
    public void shouldGetBikeRiderForBikeRide() {
        assertNotNull(BikeGearsJdbcDAOTest.NOT_YET, null);
    }

}

// That's All Folks !!
