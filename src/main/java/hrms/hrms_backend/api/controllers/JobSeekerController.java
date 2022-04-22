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

import hrms.hrms_backend.business.abstracts.JobSeekerService;
import hrms.hrms_backend.core.utilities.result.DataResult;
import hrms.hrms_backend.core.utilities.result.Result;
import hrms.hrms_backend.entities.concretes.JobSeeker;
import hrms.hrms_backend.entities.dtos.JobSeekerCvDto;

@RestController
@CrossOrigin
@RequestMapping("/api/jobseeker")
public class JobSeekerController {

    private JobSeekerService jobSeekerService;

    @Autowired
    public JobSeekerController(JobSeekerService jobSeekerService) {
        super();
        this.jobSeekerService = jobSeekerService;
    }


    @GetMapping("/getall")
    public DataResult<List<JobSeeker>> getAll() {
        return this.jobSeekerService.getAll();
    }

    @GetMapping("getCVById")
    public DataResult<JobSeekerCvDto> getCvById(@RequestParam int jobSeekerId) {

        return this.jobSeekerService.getDtoById(jobSeekerId);
    }

    @PostMapping("/add")
    public Result add(@RequestBody JobSeeker jobSeeker) {
        return this.jobSeekerService.add(jobSeeker);
    }

    @PostMapping("/update")
    public Result update(@RequestBody JobSeeker jobSeeker) {
        return this.jobSeekerService.update(jobSeeker);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody JobSeeker jobSeeker) {
        return this.jobSeekerService.delete(jobSeeker);
    }
}
