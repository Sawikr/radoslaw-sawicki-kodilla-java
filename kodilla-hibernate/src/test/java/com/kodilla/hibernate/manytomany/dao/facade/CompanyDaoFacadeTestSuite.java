package com.kodilla.hibernate.manytomany.dao.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import com.kodilla.hibernate.manytomany.facade.CompanyAndEmployeeProcessingException;
import com.kodilla.hibernate.manytomany.facade.CompanyFacade;
import com.kodilla.hibernate.manytomany.facade.EmployeeFacade;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CompanyDaoFacadeTestSuite {

    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private CompanyFacade companyFacade;

    @Autowired
    private EmployeeFacade employeeFacade;

    @Test
    void testCompanyDaoFacadeTestSuite() throws CompanyAndEmployeeProcessingException {
        //Given
        try {
            companyFacade.processCompany();
        } catch (Exception e) {
            throw new CompanyAndEmployeeProcessingException(CompanyAndEmployeeProcessingException.ERR_METHOD_DOES_NOT_WORK);
        }

        //When
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

    @Test
    void testEmployeeDaoFacadeTestSuite() throws CompanyAndEmployeeProcessingException {
        //Given
        try {
            employeeFacade.processEmployee();
        } catch (Exception e) {
            throw new CompanyAndEmployeeProcessingException(CompanyAndEmployeeProcessingException.ERR_METHOD_DOES_NOT_WORK);
        }

        //When
        List<Employee> employeeDtoList = employeeDao.retrieveLongEmployees("Smith");
        int employee = employeeDtoList.size();

        //Then
        assertEquals(2, employee);

        //CleanUp
        try {
            companyDao.deleteCompanyByIdIsGreaterThan(1);
        } catch (Exception e) {
            //do nothing
        }
    }
}


