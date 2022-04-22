package hrms.hrms_backend.business.abstracts;

import java.util.List;

import hrms.hrms_backend.core.utilities.result.DataResult;
import hrms.hrms_backend.core.utilities.result.Result;
import hrms.hrms_backend.entities.concretes.EmploymentType;

public interface EmploymentTypeService {

    DataResult<List<EmploymentType>> getAll();

    Result add(EmploymentType employmentType);
}
