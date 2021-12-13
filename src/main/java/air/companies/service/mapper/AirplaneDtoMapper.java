package air.companies.service.mapper;

import air.companies.dto.AirplaneRequestDto;
import air.companies.dto.AirplaneResponseDto;
import air.companies.model.Airplane;
import org.springframework.stereotype.Component;

@Component
public class AirplaneDtoMapper {
    public AirplaneResponseDto toDto(Airplane airplane) {
        AirplaneResponseDto airplaneResponseDto = new AirplaneResponseDto();
        airplaneResponseDto.setId(airplane.getId());
        airplaneResponseDto.setName(airplane.getName());
        airplaneResponseDto.setSerialNumber(airplane.getSerialNumber());
        airplaneResponseDto.setAirCompanyId(airplane.getAirCompanyId());
        airplaneResponseDto.setNumberOfFlights(airplane.getNumberOfFlights());
        airplaneResponseDto.setFlightDistance(airplane.getFlightDistance());
        airplaneResponseDto.setFuelCapacity(airplane.getFuelCapacity());
        airplaneResponseDto.setType(airplane.getType());
        airplaneResponseDto.setCreatedAt(airplane.getCreatedAt());
        return airplaneResponseDto;
    }

    public Airplane toModel(AirplaneRequestDto airplaneRequestDto) {
        Airplane airplane = new Airplane();
        airplane.setName(airplaneRequestDto.getName());
        airplane.setSerialNumber(airplaneRequestDto.getSerialNumber());
        airplane.setAirCompanyId(airplaneRequestDto.getAirCompanyId());
        airplane.setNumberOfFlights(airplaneRequestDto.getNumberOfFlights());
        airplane.setFlightDistance(airplaneRequestDto.getFlightDistance());
        airplane.setFuelCapacity(airplaneRequestDto.getFuelCapacity());
        airplane.setType(airplaneRequestDto.getType());
        return airplane;
    }
}
