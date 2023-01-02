package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.List;

/**
 * 7.4 Task: We calculate the number of people in the world
 */

public final class World implements PeopleQuantity{

    private List<Continent> continentList;

    public World(List<Continent> continentList) {
        this.continentList = continentList;
    }

    @Override
    public BigDecimal getPeopleQuantity(){

        return continentList.stream().flatMap(s -> s.getCountryList().stream()).
                map(Country::getPeopleQuantity).reduce(BigDecimal.ZERO, (sum, current) -> sum = sum.add(current));
    }
}