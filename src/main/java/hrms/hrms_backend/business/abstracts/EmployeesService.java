package hrms.hrms_backend.business.abstracts;

import java.util.List;

import hrms.hrms_backend.core.utilities.result.DataResult;
import hrms.hrms_backend.core.utilities.result.Result;
import hrms.hrms_backend.entities.concretes.Employees;

public interface EmployeesService {
    DataResult<Employees> getById(int employeesId);

    DataResult<List<Employees>> getAll();

    Result add(Employees employees);

    Result update(Employees employees);

    Result delete(Employees employees);
}
