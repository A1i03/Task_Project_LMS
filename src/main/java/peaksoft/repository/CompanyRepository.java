package peaksoft.repository;

import peaksoft.entity.Company;

import java.util.List;

public interface CompanyRepository {

    void saveCompany(Company newcompany);

    List<Company> getAllCompany();

    Company getByIdCompany(Long companyId);

    void updateCompany(Long companyId, Company newcompany);

    void deleteCompany(Long id);

}
