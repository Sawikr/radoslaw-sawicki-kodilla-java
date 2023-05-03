package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeFacade {

    private static final Logger LOGGER = LoggerFactory.getLogger(CompanyFacade.class);
    private final CompanyDao companyDao;

    @Autowired
    public EmployeeFacade(CompanyDao companyDao) {
        this.companyDao = companyDao;
    }

    public void processEmployee() {
        LOGGER.info("Facade processEmployee is working!");

        Employee johnSmith = new Employee("John", "Smith");
        Employee marySmith = new Employee("Mary", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        Company softwareMachine = new Company("Software Machine");

        softwareMachine.getEmployees().add(johnSmith);
        softwareMachine.getEmployees().add(marySmith);
        softwareMachine.getEmployees().add(stephanieClarckson);
        softwareMachine.getEmployees().add(lindaKovalsky);

        johnSmith.getCompanies().add(softwareMachine);
        marySmith.getCompanies().add(softwareMachine);
        stephanieClarckson.getCompanies().add(softwareMachine);
        lindaKovalsky.getCompanies().add(softwareMachine);

        companyDao.save(softwareMachine);
    }
}
