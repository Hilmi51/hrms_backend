package hrms.hrms_backend.business.abstracts;

import java.util.List;

import hrms.hrms_backend.core.utilities.result.DataResult;
import hrms.hrms_backend.core.utilities.result.Result;
import hrms.hrms_backend.entities.concretes.JobSeeker;
import hrms.hrms_backend.entities.dtos.JobSeekerCvDto;

public interface JobSeekerService {

    DataResult<JobSeeker> getByNationalIdentity(String nationalIdentity);

    DataResult<JobSeeker> getById(int jobSeekerId);

    DataResult<JobSeekerCvDto> getDtoById(int jobSeekerId);

    DataResult<List<JobSeeker>> getAll();

    Result add(JobSeeker jobSeeker);

    Result update(JobSeeker jobSeeker);

    Result delete(JobSeeker jobSeeker);
}
