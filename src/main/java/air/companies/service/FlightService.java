package air.companies.service;

import air.companies.model.Flight;
import air.companies.model.Status;
import java.util.List;

public interface FlightService {
    Flight save(Flight flight);

    List<Flight> findAll();

    Flight findById(Long id);

    void deleteById(Long id);

    List<Flight> findAirCompaniesFlightsByStatus(String companiesName, Status status);

    List<Flight> findActiveFlightsStartedMoreThanADayAgo();
}
