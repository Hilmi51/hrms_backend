package hrms.hrms_backend.entities.dtos;

import java.util.Date;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisementDto {

    private String titleName;

    private String employerName;

    private int vacancies;

    private Date applicationDeadline;
}
