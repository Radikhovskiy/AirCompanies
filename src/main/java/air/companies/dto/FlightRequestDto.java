package air.companies.dto;

import java.time.LocalDateTime;
import java.time.LocalTime;
import lombok.Data;

@Data
public class FlightRequestDto {
    private Long airCompanyId;
    private Long airplaneId;
    private String departureCountry;
    private String destinationCountry;
    private double distance;
    private LocalTime estimatedFlightTime;
    private LocalDateTime endedAt;
    private LocalDateTime delayStartedAt;
}
