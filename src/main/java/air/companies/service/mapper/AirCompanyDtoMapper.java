package air.companies.service.mapper;

import air.companies.dto.AirCompanyRequestDto;
import air.companies.dto.AirCompanyResponseDto;
import air.companies.model.AirCompany;
import org.springframework.stereotype.Component;

@Component
public class AirCompanyDtoMapper {
    public AirCompanyResponseDto toDto(AirCompany airCompany) {
        AirCompanyResponseDto airCompanyResponseDto = new AirCompanyResponseDto();
        airCompanyResponseDto.setId(airCompany.getId());
        airCompanyResponseDto.setName(airCompany.getName());
        airCompanyResponseDto.setCompanyType(airCompany.getCompanyType());
        airCompanyResponseDto.setFoundedAt(airCompany.getFoundedAt());
        return airCompanyResponseDto;
    }

    public AirCompany toModel(AirCompanyRequestDto airCompanyRequestDto) {
        AirCompany airCompany = new AirCompany();
        airCompany.setName(airCompanyRequestDto.getName());
        airCompany.setCompanyType(airCompanyRequestDto.getCompanyType());
        airCompany.setFoundedAt(airCompanyRequestDto.getFoundedAt());
        return airCompany;
    }
}
