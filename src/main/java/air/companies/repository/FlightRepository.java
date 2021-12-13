package air.companies.repository;

import air.companies.model.Flight;
import air.companies.model.Status;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
    @Query("from Flight f left join AirCompany a "
            + "on a.id = f.airCompanyId "
            + "where f.airCompanyId = :airCompanyId "
            + "and f.flightStatus = :status")
    List<Flight> findAirCompaniesFlightsByStatus(
            @Param("airCompanyId") Long airCompaniesId, @Param("status") Status status);

    @Query("from Flight f where f.createdAt > :date and f.flightStatus = :status")
    List<Flight> findActiveFlightsStartedMoreThanADayAgo(
            @Param("date") LocalDateTime date, @Param("status") Status status);
}
