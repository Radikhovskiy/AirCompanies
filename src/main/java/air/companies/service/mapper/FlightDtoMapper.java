package air.companies.service.mapper;

import air.companies.dto.FlightRequestDto;
import air.companies.dto.FlightResponseDto;
import air.companies.model.Flight;
import org.springframework.stereotype.Component;

@Component
public class FlightDtoMapper {
    public FlightResponseDto toDto(Flight flight) {
        FlightResponseDto flightResponseDto = new FlightResponseDto();
        flightResponseDto.setId(flight.getId());
        flightResponseDto.setFlightStatus(flight.getFlightStatus());
        flightResponseDto.setAirplaneId(flight.getAirplaneId());
        flightResponseDto.setAirCompanyId(flight.getAirCompanyId());
        flightResponseDto.setDepartureCountry(flight.getDepartureCountry());
        flightResponseDto.setDestinationCountry(flight.getDestinationCountry());
        flightResponseDto.setDistance(flight.getDistance());
        flightResponseDto.setEstimatedFlightTime(flight.getEstimatedFlightTime());
        flightResponseDto.setEndedAt(flight.getEndedAt());
        flightResponseDto.setDelayStartedAt(flight.getDelayStartedAt());
        flightResponseDto.setCreatedAt(flight.getCreatedAt());
        return flightResponseDto;
    }

    public Flight toModel(FlightRequestDto flightRequestDto) {
        Flight flight = new Flight();
        flight.setAirplaneId(flightRequestDto.getAirplaneId());
        flight.setAirCompanyId(flightRequestDto.getAirCompanyId());
        flight.setDepartureCountry(flightRequestDto.getDepartureCountry());
        flight.setDestinationCountry(flightRequestDto.getDestinationCountry());
        flight.setDistance(flightRequestDto.getDistance());
        flight.setEstimatedFlightTime(flightRequestDto.getEstimatedFlightTime());
        flight.setEndedAt(flightRequestDto.getEndedAt());
        flight.setDelayStartedAt(flightRequestDto.getDelayStartedAt());
        return flight;
    }
}
