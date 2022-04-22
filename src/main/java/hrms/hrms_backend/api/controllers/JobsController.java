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

import hrms.hrms_backend.business.abstracts.JobsService;
import hrms.hrms_backend.core.utilities.result.DataResult;
import hrms.hrms_backend.core.utilities.result.Result;
import hrms.hrms_backend.entities.concretes.Jobs;

@RestController
@CrossOrigin
@RequestMapping("/api/jobs")
public class JobsController {

    private JobsService jobsService;

    @Autowired
    public JobsController(JobsService jobsService) {
        super();
        this.jobsService = jobsService;
    }


    @GetMapping("/getall")
    public DataResult<List<Jobs>> getAll() {
        return this.jobsService.getAll();
    }


    @PostMapping("/add")
    public Result registerCandidate(@RequestBody Jobs jobs) {
        return this.jobsService.add(jobs);
    }

    @GetMapping("/getByJobTitleId")
    public DataResult<Jobs> getByCityId(@RequestParam("jobsId") int jobsId) {
        return this.jobsService.getJobsId(jobsId);
    }

    @PostMapping("/update")
    public Result update(@RequestBody Jobs jobs) {
        return this.jobsService.update(jobs);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody Jobs jobs) {
        return this.jobsService.delete(jobs);
    }
}
