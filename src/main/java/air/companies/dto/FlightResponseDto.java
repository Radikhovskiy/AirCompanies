package air.companies.dto;

import air.companies.model.Status;
import java.time.LocalDateTime;
import java.time.LocalTime;
import lombok.Data;

@Data
public class FlightResponseDto {
    private Long id;
    private Status flightStatus;
    private Long airCompanyId;
    private Long airplaneId;
    private String departureCountry;
    private String destinationCountry;
    private double distance;
    private LocalTime estimatedFlightTime;
    private LocalDateTime endedAt;
    private LocalDateTime delayStartedAt;
    private LocalDateTime createdAt;
}
