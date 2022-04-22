package hrms.hrms_backend.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrms_backend.business.abstracts.EmploymentTypeService;
import hrms.hrms_backend.core.utilities.result.DataResult;
import hrms.hrms_backend.core.utilities.result.Result;
import hrms.hrms_backend.entities.concretes.EmploymentType;

@RestController
@CrossOrigin
@RequestMapping("/api/employmenttype")
public class EmploymentTypeController {

    private EmploymentTypeService employmentService;

    @Autowired
    public EmploymentTypeController(EmploymentTypeService employmentService) {
        super();
        this.employmentService = employmentService;
    }


    @GetMapping("/getall")
    public DataResult<List<EmploymentType>> getAll() {
        return this.employmentService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody EmploymentType employmentType) {
        return this.employmentService.add(employmentType);
    }
}
