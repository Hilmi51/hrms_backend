package hrms.hrms_backend.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrms_backend.business.abstracts.SchoolService;
import hrms.hrms_backend.core.utilities.result.DataResult;
import hrms.hrms_backend.core.utilities.result.Result;
import hrms.hrms_backend.core.utilities.result.SuccessDataResult;
import hrms.hrms_backend.core.utilities.result.SuccessResult;
import hrms.hrms_backend.dataacceess.abstracts.SchoolDao;
import hrms.hrms_backend.entities.concretes.School;

@Service
public class SchoolManager implements SchoolService {

    private SchoolDao schoolDao;

    @Autowired
    public SchoolManager(SchoolDao schoolDao) {
        super();
        this.schoolDao = schoolDao;
    }

    @Override
    public DataResult<List<School>> getAllByCvId(int jobSeekerId) {
        return new SuccessDataResult<List<School>>(
                this.schoolDao.findAllByCv_Id(jobSeekerId)
        );
    }

    @Override
    public Result add(School school) {
        this.schoolDao.save(school);
        return new SuccessResult("School added... ");
    }

    @Override
    public Result update(School school) {
        this.schoolDao.save(school);
        return new SuccessResult("School updated... ");
    }

    @Override
    public Result delete(School school) {
        this.schoolDao.save(school);
        return new SuccessResult("School deleted... ");
    }

    @Override
    public DataResult<List<School>> getAll() {
        return new SuccessDataResult<List<School>>(
                this.schoolDao.findAll()
        );
    }
}
