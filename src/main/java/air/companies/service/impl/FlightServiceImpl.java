package air.companies.service.impl;

import air.companies.model.Flight;
import air.companies.model.Status;
import air.companies.repository.FlightRepository;
import air.companies.service.AirCompanyService;
import air.companies.service.FlightService;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class FlightServiceImpl implements FlightService {
    private final FlightRepository repository;
    private final AirCompanyService companyService;

    public FlightServiceImpl(FlightRepository repository, AirCompanyService companyService) {
        this.repository = repository;
        this.companyService = companyService;
    }

    @Override
    public Flight save(Flight flight) {
        return repository.save(flight);
    }

    @Override
    public List<Flight> findAll() {
        return repository.findAll();
    }

    @Override
    public Flight findById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Flight> findAirCompaniesFlightsByStatus(String companiesName, Status status) {
        Long airCompaniesId = companyService.findByName(companiesName).getId();
        return repository.findAirCompaniesFlightsByStatus(airCompaniesId, status);
    }

    @Override
    public List<Flight> findActiveFlightsStartedMoreThanADayAgo() {
        LocalDateTime date = LocalDateTime.now().minusDays(1L);
        return repository.findActiveFlightsStartedMoreThanADayAgo(date, Status.ACTIVE);
    }
}
