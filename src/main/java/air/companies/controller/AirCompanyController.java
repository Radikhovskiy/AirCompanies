package air.companies.controller;

import air.companies.dto.AirCompanyRequestDto;
import air.companies.dto.AirCompanyResponseDto;
import air.companies.model.AirCompany;
import air.companies.service.AirCompanyService;
import air.companies.service.mapper.AirCompanyDtoMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/air-companies")
public class AirCompanyController {
    private final AirCompanyService airCompanyService;
    private final AirCompanyDtoMapper airCompanyDtoMapper;

    public AirCompanyController(
            AirCompanyService airCompanyService, AirCompanyDtoMapper airCompanyDtoMapper) {
        this.airCompanyService = airCompanyService;
        this.airCompanyDtoMapper = airCompanyDtoMapper;
    }

    @GetMapping
    public List<AirCompanyResponseDto> getAllFlights() {
        return airCompanyService.findAll().stream()
                .map(airCompanyDtoMapper::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/add")
    public AirCompanyResponseDto addAirplane(
            @RequestBody AirCompanyRequestDto airCompanyRequestDto) {
        AirCompany airCompany = airCompanyDtoMapper.toModel(airCompanyRequestDto);
        return airCompanyDtoMapper.toDto(airCompanyService.save(airCompany));
    }
}
