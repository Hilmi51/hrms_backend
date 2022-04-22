package hrms.hrms_backend.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrms_backend.business.abstracts.SkillService;
import hrms.hrms_backend.core.utilities.result.DataResult;
import hrms.hrms_backend.core.utilities.result.Result;
import hrms.hrms_backend.core.utilities.result.SuccessDataResult;
import hrms.hrms_backend.core.utilities.result.SuccessResult;
import hrms.hrms_backend.dataacceess.abstracts.SkillDao;
import hrms.hrms_backend.entities.concretes.Skill;

@Service
public class SkillManager implements SkillService {

    private SkillDao skillDao;

    @Autowired
    public SkillManager(SkillDao skillDao) {
        super();
        this.skillDao = skillDao;
    }

    @Override
    public DataResult<List<Skill>> getAllByCvId(int jobSeekerId) {
        return new SuccessDataResult<List<Skill>>(
                this.skillDao.findAllByCv_Id(jobSeekerId)
        );
    }

    @Override
    public Result add(Skill skill) {
        this.skillDao.save(skill);
        return new SuccessResult("Skill added... ");
    }

    @Override
    public Result update(Skill skill) {
        this.skillDao.save(skill);
        return new SuccessResult("Skill updated... ");
    }

    @Override
    public Result delete(Skill skill) {
        this.skillDao.save(skill);
        return new SuccessResult("Skill deleted... ");
    }

    @Override
    public DataResult<List<Skill>> getAll() {
        return new SuccessDataResult<List<Skill>>(
                this.skillDao.findAll()
        );
    }
}
