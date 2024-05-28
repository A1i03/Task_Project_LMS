package peaksoft.repository.Impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import peaksoft.Exception.MyException;
import peaksoft.entity.Company;
import peaksoft.repository.CompanyRepository;

import java.util.List;

@RequiredArgsConstructor
@Repository
@Transactional
public class CompanyRepositoryImpl implements CompanyRepository {

    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public void saveCompany(Company newcompany) {
        try {
            entityManager.persist(newcompany);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Company> getAllCompany() {
        return entityManager.createQuery("select c from Company c",Company.class).getResultList();
    }

    @Override
    public Company getByIdCompany(Long companyId) {
        return entityManager.find(Company.class, companyId);
    }

    @Override
    public void updateCompany(Long companyId, Company newcompany) {
        Company company = entityManager.find(Company.class, companyId);
        try {
            if (company != null) {
                company.setName(newcompany.getName());
                company.setAddress(newcompany.getAddress());
                company.setCountry(newcompany.getCountry());
                company.setPhoneNumber(newcompany.getPhoneNumber());
                company.setImage(newcompany.getImage());

            } else {
                throw new MyException("Not Id?");
            }
        }catch (MyException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteCompany(Long id) {
        entityManager.remove(entityManager.find(Company.class,id));
    }

}
