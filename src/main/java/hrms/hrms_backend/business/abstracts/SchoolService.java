package hrms.hrms_backend.business.abstracts;

import java.util.List;

import hrms.hrms_backend.core.utilities.result.DataResult;
import hrms.hrms_backend.core.utilities.result.Result;
import hrms.hrms_backend.entities.concretes.School;

public interface SchoolService {

    DataResult<List<School>> getAllByCvId(int cvId);

    DataResult<List<School>> getAll();

    Result add(School school);

    Result update(School school);

    Result delete(School school);
}
