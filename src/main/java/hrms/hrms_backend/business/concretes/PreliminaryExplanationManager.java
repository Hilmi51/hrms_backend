package hrms.hrms_backend.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrms_backend.business.abstracts.PreliminaryExplanationService;
import hrms.hrms_backend.core.utilities.result.DataResult;
import hrms.hrms_backend.core.utilities.result.Result;
import hrms.hrms_backend.core.utilities.result.SuccessDataResult;
import hrms.hrms_backend.core.utilities.result.SuccessResult;
import hrms.hrms_backend.dataacceess.abstracts.PreliminaryExplanationDao;
import hrms.hrms_backend.entities.concretes.PreliminaryExplanation;

@Service
public class PreliminaryExplanationManager implements PreliminaryExplanationService {

    private PreliminaryExplanationDao preliminaryExplanationDao;

    @Autowired
    public PreliminaryExplanationManager(PreliminaryExplanationDao preliminaryExplanationDao) {
        super();
        this.preliminaryExplanationDao = preliminaryExplanationDao;
    }

    @Override
    public DataResult<List<PreliminaryExplanation>> getAllByCvId(int jobSeekerId) {
        return new SuccessDataResult<List<PreliminaryExplanation>>(
                this.preliminaryExplanationDao.findAllByCv_Id(jobSeekerId)
        );
    }

    @Override
    public Result add(PreliminaryExplanation preliminaryExplanation) {
        this.preliminaryExplanationDao.save(preliminaryExplanation);
        return new SuccessResult("Preliminary explanation added... ");
    }

    @Override
    public Result update(PreliminaryExplanation preliminaryExplanation) {
        this.preliminaryExplanationDao.save(preliminaryExplanation);
        return new SuccessResult("Preliminary explanation updated... ");
    }

    @Override
    public Result delete(PreliminaryExplanation preliminaryExplanation) {
        this.preliminaryExplanationDao.delete(preliminaryExplanation);
        return new SuccessResult("Preliminary explanation deleted... ");
    }

    @Override
    public DataResult<List<PreliminaryExplanation>> getAll() {
        return new SuccessDataResult<List<PreliminaryExplanation>>(
                this.preliminaryExplanationDao.findAll()
        );
    }
}
