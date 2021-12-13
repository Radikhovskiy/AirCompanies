package air.companies.dto;

import java.time.LocalDate;
import lombok.Data;

@Data
public class AirCompanyResponseDto {
    private Long id;
    private String name;
    private String companyType;
    private LocalDate foundedAt;
}
