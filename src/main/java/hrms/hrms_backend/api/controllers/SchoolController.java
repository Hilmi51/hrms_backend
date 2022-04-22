package hrms.hrms_backend.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrms_backend.business.abstracts.SchoolService;
import hrms.hrms_backend.core.utilities.result.Result;
import hrms.hrms_backend.entities.concretes.School;

@RestController
@CrossOrigin
@RequestMapping("/api/school")
public class SchoolController {
    private SchoolService schoolService;

    @Autowired
    public SchoolController(SchoolService schoolService) {
        super();
        this.schoolService = schoolService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody School school) {
        return this.schoolService.add(school);
    }

    @PostMapping("/update")
    public Result update(@RequestBody School school) {
        return this.schoolService.update(school);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody School school) {
        return this.schoolService.delete(school);
    }
}