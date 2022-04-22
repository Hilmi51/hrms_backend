package hrms.hrms_backend.dataacceess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrms_backend.entities.concretes.JobExperience;


public interface JobExperienceDao extends JpaRepository<JobExperience, Integer> {
    List<JobExperience> findByCv_Id(int id);
}
