package peaksoft.repository;

import peaksoft.entity.Company;

import java.util.List;
import java.util.Optional;

public interface CompanyRepository {

    void saveCompany(Company newcompany);

    List<Company> getAllCompany();

    Optional<Company> getByIdCompany(Long companyId);

    void updateCompany(Long companyId, Company newcompany);

    void deleteCompany(Long companyId);

}
