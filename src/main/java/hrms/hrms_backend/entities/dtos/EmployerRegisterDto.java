package hrms.hrms_backend.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployerRegisterDto {

    private String employerWebsite;
    private String employerPhoneNumber;
    private String companyName;
    private String employerEmail;
    private String password;
    private String confirmPassword;
}
