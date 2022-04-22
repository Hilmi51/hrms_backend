package hrms.hrms_backend.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import hrms.hrms_backend.business.abstracts.EmploymentTypeService;
import hrms.hrms_backend.core.utilities.result.DataResult;
import hrms.hrms_backend.core.utilities.result.Result;
import hrms.hrms_backend.core.utilities.result.SuccessDataResult;
import hrms.hrms_backend.core.utilities.result.SuccessResult;
import hrms.hrms_backend.dataacceess.abstracts.EmploymentTypeDao;
import hrms.hrms_backend.entities.concretes.EmploymentType;

@Service
public class EmploymentTypeManager implements EmploymentTypeService {

    private EmploymentTypeDao employmentDao;

    public EmploymentTypeManager(EmploymentTypeDao employmentDao) {
        super();
        this.employmentDao = employmentDao;
    }

    @Override
    public DataResult<List<EmploymentType>> getAll() {
        return new SuccessDataResult<List<EmploymentType>>(
                this.employmentDao.findAll()
        );
    }

    @Override
    public Result add(EmploymentType employmentType) {
        this.employmentDao.save(employmentType);
        return new SuccessResult("Employment type added... ");
    }

}
