package air.companies.controller;

import air.companies.dto.FlightRequestDto;
import air.companies.dto.FlightResponseDto;
import air.companies.model.Flight;
import air.companies.model.Status;
import air.companies.service.FlightService;
import air.companies.service.mapper.FlightDtoMapper;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/flights")
public class FlightController {
    private final FlightService flightService;
    private final FlightDtoMapper flightDtoMapper;

    public FlightController(FlightService flightService, FlightDtoMapper flightDtoMapper) {
        this.flightService = flightService;
        this.flightDtoMapper = flightDtoMapper;
    }

    @GetMapping
    public List<FlightResponseDto> getAllFlights() {
        return flightService.findAll().stream()
                .map(flightDtoMapper::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/add")
    public FlightResponseDto addFlight(@RequestBody FlightRequestDto flightRequestDto) {
        Flight flight = flightDtoMapper.toModel(flightRequestDto);
        flight.setFlightStatus(Status.PENDING);
        flight.setCreatedAt(LocalDateTime.now());
        return flightDtoMapper.toDto(flightService.save(flight));
    }

    @GetMapping("/{companiesName}")
    public List<FlightResponseDto> findAirCompaniesFlightsByStatus(
            @PathVariable String companiesName, @RequestParam Status status) {
        return flightService.findAirCompaniesFlightsByStatus(companiesName, status).stream()
                .map(flightDtoMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/active-after-a-day")
    public List<FlightResponseDto> findActiveFlightsStartedMoreThanADayAgo() {
        return flightService.findActiveFlightsStartedMoreThanADayAgo().stream()
                .map(flightDtoMapper::toDto)
                .collect(Collectors.toList());
    }

    @PatchMapping("change-status/{flightId}")
    public FlightResponseDto changeStatus(
            @PathVariable Long flightId, @RequestParam Status status) {
        LocalDateTime now = LocalDateTime.now();
        Flight flight = flightService.findById(flightId);
        flight.setFlightStatus(status);
        if (status == Status.ACTIVE) {
            flight.setCreatedAt(now);
        } else if (status == Status.DELAYED) {
            flight.setDelayStartedAt(now);
        } else if (status == Status.COMPLETED) {
            flight.setEndedAt(now);
        }
        return flightDtoMapper.toDto(flightService.save(flight));
    }
}
