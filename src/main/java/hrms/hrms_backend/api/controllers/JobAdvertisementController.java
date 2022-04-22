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

import hrms.hrms_backend.business.abstracts.JobAdvertisementService;
import hrms.hrms_backend.core.utilities.result.DataResult;
import hrms.hrms_backend.core.utilities.result.Result;
import hrms.hrms_backend.entities.concretes.JobAdvertisement;


@RestController
@CrossOrigin
@RequestMapping("/api/jobadvertisement")
public class JobAdvertisementController {

    private JobAdvertisementService jobAdvertisementService;

    @Autowired
    public JobAdvertisementController(JobAdvertisementService jobAdvertisementService) {
        super();
        this.jobAdvertisementService = jobAdvertisementService;
    }


    @PostMapping("/add")
    public Result add(@RequestBody JobAdvertisement jobAdvertisement) {
        return this.jobAdvertisementService.add(jobAdvertisement);
    }


    @GetMapping("/getByIsActive")
    public DataResult<List<JobAdvertisement>> getByIsActive() {
        return this.jobAdvertisementService.getByIsActive();
    }


    @GetMapping("/getByAppealDeadline")
    public DataResult<List<JobAdvertisement>> getByAppealDeadline() {
        return this.jobAdvertisementService.getAllSortedByReleaseDate();
    }

    @GetMapping("/employeeVerified")
    public Result toggleVerifiedByEmployee(@RequestParam int adminId) {
        return this.jobAdvertisementService.enableAdmin(adminId);
    }

    @GetMapping("/toggleactive")
    public Result update(@RequestParam int adminId) {
        return this.jobAdvertisementService.changeVerifiedByAdmin(adminId);
    }

    @PostMapping("/update")
    public Result update(@RequestBody JobAdvertisement jobAdvertisement) {
        return this.jobAdvertisementService.update(jobAdvertisement);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody JobAdvertisement jobAdvertisement) {
        return this.jobAdvertisementService.delete(jobAdvertisement);
    }

    @GetMapping("/getall")
    public DataResult<List<JobAdvertisement>> getAll() {
        return this.jobAdvertisementService.getAll();
    }
}
