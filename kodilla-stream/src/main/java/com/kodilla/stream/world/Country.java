package com.kodilla.stream.world;

import java.math.BigDecimal;

public final class Country implements PeopleQuantity{

    private String countryName;
    private BigDecimal peopleQuantity;

    public Country(final String countryName, final BigDecimal peopleQuantity) {
        this.countryName = countryName;
        this.peopleQuantity = peopleQuantity;
    }

    @Override
    public BigDecimal getPeopleQuantity(){
        return peopleQuantity;
    }

}