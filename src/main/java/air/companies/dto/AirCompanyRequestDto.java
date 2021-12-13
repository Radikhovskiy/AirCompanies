package air.companies.dto;

import java.time.LocalDate;
import lombok.Data;

@Data
public class AirCompanyRequestDto {
    private String name;
    private String companyType;
    private LocalDate foundedAt;
}
