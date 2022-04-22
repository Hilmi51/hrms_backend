package hrms.hrms_backend.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrms_backend.business.abstracts.JobsService;
import hrms.hrms_backend.core.utilities.result.DataResult;
import hrms.hrms_backend.core.utilities.result.ErorResult;
import hrms.hrms_backend.core.utilities.result.Result;
import hrms.hrms_backend.core.utilities.result.SuccessDataResult;
import hrms.hrms_backend.core.utilities.result.SuccessResult;
import hrms.hrms_backend.dataacceess.abstracts.JobsDao;
import hrms.hrms_backend.entities.concretes.Jobs;

@Service
public class JobsManager implements JobsService {

    private JobsDao jobsDao;

    @Autowired
    public JobsManager(JobsDao jobsDao) {
        super();
        this.jobsDao = jobsDao;
    }

    @Override
    public DataResult<Jobs> getByExplanation(String explanation) {
        return new SuccessDataResult<Jobs>(
                this.jobsDao.findByExplanation(explanation)
        );
    }

    @Override
    public DataResult<Jobs> getJobsId(int jobsId) {
        return new SuccessDataResult<Jobs>(
                this.jobsDao.getOne(jobsId)
        );
    }

    @Override
    public DataResult<List<Jobs>> getAll() {
        return new SuccessDataResult<List<Jobs>>(
                this.jobsDao.findAll()
        );
    }

    @Override
    public Result add(Jobs jobs) {
        if (!this.isTitleExist(jobs.getExplanation())) {

            return new ErorResult("Jobs exist ! ");
        }

        this.jobsDao.save(jobs);
        return new SuccessResult("Jobs added... ");
    }

    @Override
    public Result update(Jobs jobs) {
        this.jobsDao.save(jobs);
        return new SuccessResult("Jobs updated... ");
    }

    @Override
    public Result delete(Jobs jobs) {
        this.jobsDao.delete(jobs);
        return new SuccessResult("Jobs deleted... ");
    }

    private boolean isTitleExist(String explanation) {
        if (this.jobsDao.findByExplanation(explanation) != null) {
            return false;
        }
        return true;

    }
}
