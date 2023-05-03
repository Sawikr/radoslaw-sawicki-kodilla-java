package com.kodilla.hibernate.manytomany.facade;

public class CompanyAndEmployeeProcessingException extends Exception {

    public static String ERR_METHOD_DOES_NOT_WORK = "The method doesn't work";

    public CompanyAndEmployeeProcessingException(String message) {
        super(message);
    }
}
