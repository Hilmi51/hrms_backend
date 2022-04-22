package hrms.hrms_backend.business.abstracts;

import hrms.hrms_backend.core.utilities.result.Result;
import hrms.hrms_backend.entities.dtos.EmployerRegisterDto;
import hrms.hrms_backend.entities.dtos.JobSeekerRegisterDto;

public interface AuthService {

    Result registerEmployer(EmployerRegisterDto employerRegisterDto);

    Result registerJobSeeker(JobSeekerRegisterDto jobSeekerRegisterDto);

    Result verifyEmail(int userId, String activationCode);
}
