package peaksoft.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.entity.Company;
import peaksoft.repository.CompanyRepository;
import peaksoft.service.CompanyService;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service

public class CompanyServiceImpl implements CompanyService {

    private  final CompanyRepository companyRepository;

    @Override
    public void saveCompany(Company newcompany) {
        companyRepository.saveCompany(newcompany);
    }
    @Override
    public List<Company> getAllCompany() {
        return companyRepository.getAllCompany();
    }

    @Override
    public Company getByIdCompany(Long companyId) {
        return companyRepository.getByIdCompany(companyId);
    }

    @Override
    public void updateCompany(Long companyId, Company newcompany) {
        companyRepository.updateCompany(companyId,newcompany);
    }

    @Override
    public void deleteCompany(Long Id) {
        companyRepository.deleteCompany(Id);
    }
}
