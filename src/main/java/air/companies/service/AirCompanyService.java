package air.companies.service;

import air.companies.model.AirCompany;
import java.util.List;

public interface AirCompanyService {
    AirCompany save(AirCompany airCompany);

    List<AirCompany> findAll();

    AirCompany findById(Long id);

    void deleteById(Long id);

    AirCompany findByName(String name);
}
