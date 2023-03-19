package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
//import javax.transaction.Transactional;

@Transactional
@Repository
public interface CompanyDao extends CrudRepository<Company, Integer> {

    void deleteCompanyByIdIsGreaterThan(int i);

    @Query(nativeQuery = true)
    List<Company> retrieveLongCompanies();
}
