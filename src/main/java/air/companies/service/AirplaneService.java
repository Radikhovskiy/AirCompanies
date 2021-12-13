package air.companies.service;

import air.companies.model.Airplane;
import java.util.List;

public interface AirplaneService {
    Airplane save(Airplane airplane);

    List<Airplane> findAll();

    Airplane findById(Long id);

    void deleteById(Long id);

    Airplane findByName(String name);
}
