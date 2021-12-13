package air.companies.service.impl;

import air.companies.model.AirCompany;
import air.companies.repository.AirCompanyRepository;
import air.companies.service.AirCompanyService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class AirCompanyServiceImpl implements AirCompanyService {
    private final AirCompanyRepository repository;

    public AirCompanyServiceImpl(AirCompanyRepository repository) {
        this.repository = repository;
    }

    @Override
    public AirCompany save(AirCompany airCompany) {
        return repository.save(airCompany);
    }

    @Override
    public List<AirCompany> findAll() {
        return repository.findAll();
    }

    @Override
    public AirCompany findById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public AirCompany findByName(String name) {
        return repository.findByName(name).get();
    }
}
