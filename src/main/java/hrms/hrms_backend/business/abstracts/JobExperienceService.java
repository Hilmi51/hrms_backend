package hrms.hrms_backend.business.abstracts;

import java.util.List;

import hrms.hrms_backend.core.utilities.result.DataResult;
import hrms.hrms_backend.core.utilities.result.Result;
import hrms.hrms_backend.entities.concretes.JobExperience;

public interface JobExperienceService {

    DataResult<List<JobExperience>> getAllByCvId(int cvId);

    DataResult<List<JobExperience>> getAll();

    Result add(JobExperience jobExperinence);

    Result update(JobExperience jobExperinence);

    Result delete(JobExperience jobExperinence);
}
