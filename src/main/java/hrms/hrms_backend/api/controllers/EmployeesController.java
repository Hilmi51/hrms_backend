package hrms.hrms_backend.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrms_backend.business.abstracts.EmployeesService;
import hrms.hrms_backend.core.utilities.result.DataResult;
import hrms.hrms_backend.core.utilities.result.Result;
import hrms.hrms_backend.entities.concretes.Employees;

@RestController
@CrossOrigin
@RequestMapping("/api/employees")
public class EmployeesController {

    private EmployeesService employeesService;

    @Autowired
    public EmployeesController(EmployeesService employeesService) {
        super();
        this.employeesService = employeesService;
    }


    @GetMapping("/getall")
    public DataResult<List<Employees>> getAll() {
        return this.employeesService.getAll();
    }

    @GetMapping("getbyid")
    public DataResult<Employees> getById(@RequestParam("id") int employeesId) {
        return this.employeesService.getById(employeesId);
    }

    @PostMapping("/add")
    public Result add(@RequestBody Employees employees) {
        return this.employeesService.add(employees);
    }

    @PostMapping("/update")
    public Result update(@RequestBody Employees employees) {
        return this.employeesService.update(employees);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody Employees employees) {
        return this.employeesService.delete(employees);
    }
}
