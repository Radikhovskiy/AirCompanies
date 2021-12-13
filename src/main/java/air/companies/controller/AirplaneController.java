package air.companies.controller;

import air.companies.dto.AirplaneRequestDto;
import air.companies.dto.AirplaneResponseDto;
import air.companies.model.Airplane;
import air.companies.service.AirCompanyService;
import air.companies.service.AirplaneService;
import air.companies.service.mapper.AirplaneDtoMapper;
import java.time.LocalDate;
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
@RequestMapping("/airplanes")
public class AirplaneController {
    private final AirplaneService airplaneService;
    private final AirCompanyService airCompanyService;
    private final AirplaneDtoMapper airplaneDtoMapper;

    public AirplaneController(
            AirplaneService airplaneService, AirCompanyService airCompanyService,
            AirplaneDtoMapper airplaneDtoMapper) {
        this.airplaneService = airplaneService;
        this.airCompanyService = airCompanyService;
        this.airplaneDtoMapper = airplaneDtoMapper;
    }

    @GetMapping
    public List<AirplaneResponseDto> getAllFlights() {
        return airplaneService.findAll().stream()
                .map(airplaneDtoMapper::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/add")
    public AirplaneResponseDto addAirplane(@RequestBody AirplaneRequestDto airplaneRequestDto) {
        Airplane airplane = airplaneDtoMapper.toModel(airplaneRequestDto);
        airplane.setCreatedAt(LocalDate.now());
        return airplaneDtoMapper.toDto(airplaneService.save(airplane));
    }

    @PatchMapping("/change/{airplaneName}")
    public AirplaneResponseDto changeCompany(
            @PathVariable String airplaneName, @RequestParam String companyName) {
        Airplane airplane = airplaneService.findByName(airplaneName);
        Long id = airCompanyService.findByName(companyName).getId();
        airplane.setAirCompanyId(id);
        airplaneService.save(airplane);
        return airplaneDtoMapper.toDto(airplane);
    }
}
