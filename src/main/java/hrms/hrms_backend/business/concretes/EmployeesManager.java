package hrms.hrms_backend.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrms_backend.business.abstracts.EmployeesService;
import hrms.hrms_backend.core.utilities.result.DataResult;
import hrms.hrms_backend.core.utilities.result.Result;
import hrms.hrms_backend.core.utilities.result.SuccessDataResult;
import hrms.hrms_backend.core.utilities.result.SuccessResult;
import hrms.hrms_backend.dataacceess.abstracts.EmployeesDao;
import hrms.hrms_backend.entities.concretes.Employees;

@Service
public class EmployeesManager implements EmployeesService {

    private EmployeesDao employeesDao;

    @Autowired
    public EmployeesManager(EmployeesDao employeesDao) {
        super();
        this.employeesDao = employeesDao;
    }

    @Override
    public DataResult<Employees> getById(int employeesId) {
        return new SuccessDataResult<Employees>(
                this.employeesDao.findById(employeesId)
        );
    }

    @Override
    public DataResult<List<Employees>> getAll() {
        return new SuccessDataResult<List<Employees>>(
                this.employeesDao.findAll()
        );
    }

    @Override
    public Result add(Employees employees) {
        this.employeesDao.save(employees);
        return new SuccessResult("Employees added... ");
    }

    @Override
    public Result update(Employees employees) {
        this.employeesDao.save(employees);
        return new SuccessResult("Employees updated... ");
    }

    @Override
    public Result delete(Employees employees) {
        this.employeesDao.delete(employees);
        return new SuccessResult("Employees deleted... ");
    }
}
