package air.companies.dto;

import lombok.Data;

@Data
public class AirplaneRequestDto {
    private String name;
    private int serialNumber;
    private Long airCompanyId;
    private int numberOfFlights;
    private int flightDistance;
    private int fuelCapacity;
    private String type;
}
