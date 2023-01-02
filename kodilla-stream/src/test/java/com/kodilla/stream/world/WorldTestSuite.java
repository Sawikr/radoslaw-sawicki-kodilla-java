package com.kodilla.stream.world;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WorldTestSuite {

    private static final Logger LOGGER = Logger.getLogger(WorldTestSuite.class.getName());

    private static int testCounter = 0;

    @BeforeEach
    public void before() {
        System.out.println("\nTest Case: begin!");
    }

    @AfterEach
    public void after() {
        System.out.println("Test Case: end!");
    }

    @BeforeEach
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }


    @DisplayName("Name of test: testGetPeopleQuantity")
    @Test
    void testGetPeopleQuantity() {
        //Given
        final List<Country> countriesListInAsia = new ArrayList<>();
        countriesListInAsia.add(new Country("China", new BigDecimal("12545565555454")));
        countriesListInAsia.add(new Country("India", new BigDecimal("12545612211544")));

        final List<Country> countriesListInAfrica = new ArrayList<>();
        countriesListInAfrica.add(new Country("Nigeria", new BigDecimal("1254566444665")));
        countriesListInAfrica.add(new Country("South Africa", new BigDecimal("1256488964661")));

        final List<Country> countriesListInEuropa = new ArrayList<>();
        countriesListInEuropa.add(new Country("Poland", new BigDecimal("1254566444444")));
        countriesListInEuropa.add(new Country("Germany", new BigDecimal("1256488964444")));

        final List<Continent> continentList = new ArrayList<>();
        continentList.add(new Continent("Asia", countriesListInAsia));
        continentList.add(new Continent("Africa", countriesListInAfrica));
        continentList.add(new Continent("Europe", countriesListInEuropa));

        final List<World> worldList = new ArrayList<>();
        worldList.add(new World(continentList));

        //When
        World world = new World(continentList);
        LOGGER.info("peopleQuantity is: " + world.getPeopleQuantity());
        BigDecimal result = world.getPeopleQuantity();

        //Then
        BigDecimal expectedPeopleQuantity = new BigDecimal("30113288585212");
        assertEquals(expectedPeopleQuantity, result);
    }

    @DisplayName("Name of test: testGetPeopleQuantityIsOne")
    @Test
    void testGetPeopleQuantityIsOne() {
        //Given
        final List<Country> countriesListInAsia = new ArrayList<>();
        countriesListInAsia.add(new Country("China", new BigDecimal("1")));
        countriesListInAsia.add(new Country("India", new BigDecimal("1")));

        final List<Country> countriesListInAfrica = new ArrayList<>();
        countriesListInAfrica.add(new Country("Nigeria", new BigDecimal("1")));
        countriesListInAfrica.add(new Country("South Africa", new BigDecimal("1")));

        final List<Country> countriesListInEuropa = new ArrayList<>();
        countriesListInEuropa.add(new Country("Poland", new BigDecimal("1")));
        countriesListInEuropa.add(new Country("Germany", new BigDecimal("1")));

        final List<Continent> continentList = new ArrayList<>();
        continentList.add(new Continent("Asia", countriesListInAsia));
        continentList.add(new Continent("Africa", countriesListInAfrica));
        continentList.add(new Continent("Europe", countriesListInEuropa));

        final List<World> worldList = new ArrayList<>();
        worldList.add(new World(continentList));

        //When
        World world = new World(continentList);
        LOGGER.info("peopleQuantity is: " + world.getPeopleQuantity());
        BigDecimal result = world.getPeopleQuantity();

        //Then
        BigDecimal expectedPeopleQuantity = new BigDecimal("6");
        assertEquals(expectedPeopleQuantity, result);
    }
}
