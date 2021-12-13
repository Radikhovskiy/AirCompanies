package air.companies.service.impl;

import air.companies.model.Airplane;
import air.companies.repository.AirplaneRepository;
import air.companies.service.AirplaneService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class AirplaneServiceImpl implements AirplaneService {
    private final AirplaneRepository repository;

    public AirplaneServiceImpl(AirplaneRepository repository) {
        this.repository = repository;
    }

    @Override
    public Airplane save(Airplane airplane) {
        return repository.save(airplane);
    }

    @Override
    public List<Airplane> findAll() {
        return repository.findAll();
    }

    @Override
    public Airplane findById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Airplane findByName(String name) {
        return repository.findByName(name).get();
    }
}
