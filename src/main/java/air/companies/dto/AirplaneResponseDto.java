package air.companies.dto;

import java.time.LocalDate;
import lombok.Data;

@Data
public class AirplaneResponseDto {
    private Long id;
    private String name;
    private int serialNumber;
    private Long airCompanyId;
    private int numberOfFlights;
    private int flightDistance;
    private int fuelCapacity;
    private String type;
    private LocalDate createdAt;
}
