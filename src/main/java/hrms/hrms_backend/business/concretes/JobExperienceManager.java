package hrms.hrms_backend.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrms_backend.business.abstracts.JobExperienceService;
import hrms.hrms_backend.core.utilities.result.DataResult;
import hrms.hrms_backend.core.utilities.result.Result;
import hrms.hrms_backend.core.utilities.result.SuccessDataResult;
import hrms.hrms_backend.core.utilities.result.SuccessResult;
import hrms.hrms_backend.dataacceess.abstracts.JobExperienceDao;
import hrms.hrms_backend.entities.concretes.JobExperience;

@Service
public class JobExperienceManager implements JobExperienceService {

    public JobExperienceDao jobExperienceDao;

    @Autowired
    public JobExperienceManager(JobExperienceDao jobExperienceDao) {
        super();
        this.jobExperienceDao = jobExperienceDao;
    }

    @Override
    public DataResult<List<JobExperience>> getAllByCvId(int cvId) {
        return new SuccessDataResult<List<JobExperience>>(
                this.jobExperienceDao.findByCv_Id(cvId)
        );
    }

    @Override
    public DataResult<List<JobExperience>> getAll() {
        return new SuccessDataResult<List<JobExperience>>(
                this.jobExperienceDao.findAll()
        );
    }

    @Override
    public Result add(JobExperience jobExperinence) {
        this.jobExperienceDao.save(jobExperinence);
        return new SuccessResult("Job experience added... ");
    }

    @Override
    public Result update(JobExperience jobExperinence) {
        this.jobExperienceDao.save(jobExperinence);
        return new SuccessResult("Job experience updated... ");
    }

    @Override
    public Result delete(JobExperience jobExperinence) {
        this.jobExperienceDao.delete(jobExperinence);
        return new SuccessResult("Job experience deleted... ");
    }
}
