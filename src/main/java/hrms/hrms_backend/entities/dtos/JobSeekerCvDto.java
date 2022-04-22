package hrms.hrms_backend.entities.dtos;

import java.util.List;

import hrms.hrms_backend.entities.concretes.JobExperience;
import hrms.hrms_backend.entities.concretes.JobSeeker;
import hrms.hrms_backend.entities.concretes.Language;
import hrms.hrms_backend.entities.concretes.Link;
import hrms.hrms_backend.entities.concretes.PreliminaryExplanation;
import hrms.hrms_backend.entities.concretes.School;
import hrms.hrms_backend.entities.concretes.Skill;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobSeekerCvDto {

    public JobSeeker jobSeeker;
    public List<School> schools;
    public List<Skill> skills;
    public List<Link> links;
    public List<Language> languages;
    public List<JobExperience> jobExperiences;
    public List<PreliminaryExplanation> preliminaryExplanations;
}

