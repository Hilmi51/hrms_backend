package hrms.hrms_backend.business.abstracts;

import java.util.List;

import hrms.hrms_backend.core.utilities.result.DataResult;
import hrms.hrms_backend.core.utilities.result.Result;
import hrms.hrms_backend.entities.concretes.Jobs;

public interface JobsService {

    DataResult<Jobs> getByExplanation(String explanation);

    DataResult<Jobs> getJobsId(int jobsId);

    DataResult<List<Jobs>> getAll();

    Result add(Jobs jobs);

    Result update(Jobs jobs);

    Result delete(Jobs jobs);
}
