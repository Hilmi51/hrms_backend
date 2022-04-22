package hrms.hrms_backend.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrms_backend.business.abstracts.JobExperienceService;
import hrms.hrms_backend.core.utilities.result.DataResult;
import hrms.hrms_backend.core.utilities.result.Result;
import hrms.hrms_backend.entities.concretes.JobExperience;

@RestController
@RequestMapping("/api/jobexperience")
public class JobExperienceController {

    private JobExperienceService jobExperienceService;

    @Autowired
    public JobExperienceController(JobExperienceService jobExperienceService) {
        super();
        this.jobExperienceService = jobExperienceService;
    }


    @PostMapping("/add")
    public Result add(@RequestBody JobExperience jobExperience) {
        return this.jobExperienceService.add(jobExperience);
    }

    @PostMapping("/update")
    public Result update(@RequestBody JobExperience jobExperience) {
        return this.jobExperienceService.update(jobExperience);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody JobExperience jobExperience) {

        return this.jobExperienceService.delete(jobExperience);
    }

    @GetMapping("/getall")
    public DataResult<List<JobExperience>> getAll() {
        return this.jobExperienceService.getAll();
    }
}
