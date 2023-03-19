package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
public class CompanyDaoTestSuite {

        @Autowired
        private CompanyDao companyDao;

        @Autowired
        private EmployeeDao employeeDao;

        @Test
        void testSaveManyToMany() {
            //Given
            Employee johnSmith = new Employee("John", "Smith");
            Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
            Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

            Company softwareMachine = new Company("Software Machine");
            Company dataMaesters = new Company("Data Maesters");
            Company greyMatter = new Company("Grey Matter");

            softwareMachine.getEmployees().add(johnSmith);
            dataMaesters.getEmployees().add(stephanieClarckson);
            dataMaesters.getEmployees().add(lindaKovalsky);
            greyMatter.getEmployees().add(johnSmith);
            greyMatter.getEmployees().add(lindaKovalsky);

            johnSmith.getCompanies().add(softwareMachine);
            johnSmith.getCompanies().add(greyMatter);
            stephanieClarckson.getCompanies().add(dataMaesters);
            lindaKovalsky.getCompanies().add(dataMaesters);
            lindaKovalsky.getCompanies().add(greyMatter);

            //When
            companyDao.save(softwareMachine);
            int softwareMachineId = softwareMachine.getId();
            companyDao.save(dataMaesters);
            int dataMaestersId = dataMaesters.getId();
            companyDao.save(greyMatter);
            int greyMatterId = greyMatter.getId();

            //Then
            assertNotEquals(0, softwareMachineId);
            assertNotEquals(0, dataMaestersId);
            assertNotEquals(0, greyMatterId);

            //CleanUp
            try {
                companyDao.deleteCompanyByIdIsGreaterThan(1);
            } catch (Exception e) {
                //do nothing
            }
        }

    @Test
    void testEmployeeDaoTestSuite() {
        //Given
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

        //When
        companyDao.save(softwareMachine);
        List<Employee> employeeList = employeeDao.retrieveLongEmployees("Smith");
        int employee = employeeList.size();

        //Then
        assertEquals(2, employee);

        //CleanUp
        try {
            companyDao.deleteCompanyByIdIsGreaterThan(1);
        } catch (Exception e) {
            //do nothing
        }
    }

    @Test
    void testCompanyDaoTestSuite() {
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        Company softwareMachine = new Company("Software Machine");
        Company softwareMac = new Company("Software Mac");
        Company dataMaesters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey Matter");

        softwareMachine.getEmployees().add(johnSmith);
        softwareMac.getEmployees().add(johnSmith);
        dataMaesters.getEmployees().add(stephanieClarckson);
        dataMaesters.getEmployees().add(lindaKovalsky);
        greyMatter.getEmployees().add(johnSmith);
        greyMatter.getEmployees().add(lindaKovalsky);

        johnSmith.getCompanies().add(softwareMachine);
        johnSmith.getCompanies().add(softwareMac);
        johnSmith.getCompanies().add(greyMatter);
        stephanieClarckson.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(greyMatter);

        //When
        companyDao.save(softwareMachine);
        companyDao.save(softwareMac);
        List<Company> companyList = companyDao.retrieveLongCompanies();
        int company = companyList.size();

        //Then
        assertEquals(2, company);

        //CleanUp
        try {
            companyDao.deleteCompanyByIdIsGreaterThan(1);
        } catch (Exception e) {
            //do nothing
        }
    }
}
