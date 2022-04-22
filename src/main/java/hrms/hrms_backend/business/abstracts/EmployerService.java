package hrms.hrms_backend.business.abstracts;

import java.util.List;

import hrms.hrms_backend.core.utilities.result.DataResult;
import hrms.hrms_backend.core.utilities.result.Result;
import hrms.hrms_backend.entities.concretes.Employer;

public interface EmployerService {

    DataResult<Employer> getById(int id);

    DataResult<Employer> getByEmail(String email);

    DataResult<List<Employer>> getAll();

    Result add(Employer employer);

    Result update(Employer employer);

    Result delete(Employer employer);
}
