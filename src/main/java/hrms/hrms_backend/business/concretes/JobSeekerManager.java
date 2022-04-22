package hrms.hrms_backend.business.concretes;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrms_backend.business.abstracts.JobExperienceService;
import hrms.hrms_backend.business.abstracts.JobSeekerService;
import hrms.hrms_backend.business.abstracts.LanguageService;
import hrms.hrms_backend.business.abstracts.LinkService;
import hrms.hrms_backend.business.abstracts.PreliminaryExplanationService;
import hrms.hrms_backend.business.abstracts.SchoolService;
import hrms.hrms_backend.business.abstracts.SkillService;
import hrms.hrms_backend.core.utilities.mernisadapters.UserCheckService;
import hrms.hrms_backend.core.utilities.result.DataResult;
import hrms.hrms_backend.core.utilities.result.ErorResult;
import hrms.hrms_backend.core.utilities.result.Result;
import hrms.hrms_backend.core.utilities.result.SuccessDataResult;
import hrms.hrms_backend.core.utilities.result.SuccessResult;
import hrms.hrms_backend.dataacceess.abstracts.JobSeekerDao;
import hrms.hrms_backend.entities.concretes.JobSeeker;
import hrms.hrms_backend.entities.dtos.JobSeekerCvDto;

@Service
public class JobSeekerManager implements JobSeekerService {

    private JobSeekerDao jobSeekerDao;
    private UserCheckService userCheckService;
    private JobExperienceService jobExperienceService;
    private LanguageService languageService;
    private LinkService linkService;
    private SkillService skillService;
    private SchoolService schoolService;
    private PreliminaryExplanationService preliminaryExplanationService;

    @Autowired
    public JobSeekerManager(JobSeekerDao jobSeekerDao, UserCheckService userCheckService,
                            JobExperienceService jobExperienceService, LanguageService languageService,
                            LinkService linkService, SkillService skillService, SchoolService schoolService,
                            PreliminaryExplanationService preliminaryExplanationService) {
        super();
        this.jobSeekerDao = jobSeekerDao;
        this.userCheckService = userCheckService;
        this.jobExperienceService = jobExperienceService;
        this.languageService = languageService;
        this.linkService = linkService;
        this.skillService = skillService;
        this.schoolService = schoolService;
        this.preliminaryExplanationService = preliminaryExplanationService;
    }

    @Override
    public DataResult<JobSeeker> getByNationalIdentity(String nationalIdentity) {
        return new SuccessDataResult<JobSeeker>(
                this.jobSeekerDao.findByNationalIdentity(nationalIdentity)
        );
    }

    @Override
    public DataResult<JobSeeker> getById(int jobSeekerId) {
        return new SuccessDataResult<JobSeeker>(
                this.jobSeekerDao.findById(jobSeekerId)
        );
    }

    @Override
    public DataResult<JobSeekerCvDto> getDtoById(int cvId) {
        JobSeekerCvDto cvDto = new JobSeekerCvDto();

        cvDto.jobExperiences = this.jobExperienceService.getAllByCvId(cvId).getData();
        cvDto.preliminaryExplanations = this.preliminaryExplanationService.getAllByCvId(cvId).getData();
        cvDto.skills = this.skillService.getAllByCvId(cvId).getData();
        cvDto.links = this.linkService.getAllByCvId(cvId).getData();
        cvDto.languages = this.languageService.getAllByCvId(cvId).getData();
        cvDto.schools = this.schoolService.getAllByCvId(cvId).getData();
        return new SuccessDataResult<JobSeekerCvDto>(cvDto);
    }

    @Override
    public DataResult<List<JobSeeker>> getAll() {
        return new SuccessDataResult<List<JobSeeker>>(
                this.jobSeekerDao.findAll()
        );
    }

    @Override
    public Result add(JobSeeker jobSeeker) {
        if (!checkIfRealPerson(jobSeeker)) {
            return new ErorResult("Invalid person ! ");
        }
        if (!checkIfNationalityId(jobSeeker.getNationalIdentity())) {
            return new ErorResult("Nationality already exist ! ");
        }
        this.jobSeekerDao.save(jobSeeker);
        return new SuccessResult("Job seeker added... ");
    }

    @Override
    public Result update(JobSeeker jobSeeker) {
        this.jobSeekerDao.save(jobSeeker);
        return new SuccessResult("Job seeker updated... ");
    }

    @Override
    public Result delete(JobSeeker jobSeeker) {
        this.jobSeekerDao.delete(jobSeeker);
        return new SuccessResult("Job seeker deleted... ");
    }

    private boolean checkIfNationalityId(String nationalityId) {
        if (this.jobSeekerDao.findByNationalIdentity(nationalityId) != null) {
            return false;
        }
        return true;
    }

    private boolean checkIfRealPerson(JobSeeker jobSeeker) {
        if (!this.userCheckService.checkIfRealPerson(Long.parseLong(jobSeeker.getNationalIdentity()), jobSeeker.getFirstName().toUpperCase(new Locale("tr")), jobSeeker.getLastName().toLowerCase(new Locale("tr")),
                jobSeeker.getYearsOfBirth())) {
            return false;
        }

        return true;
    }
}