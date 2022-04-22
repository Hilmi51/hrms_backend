package hrms.hrms_backend.dataacceess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrms_backend.entities.concretes.JobSeeker;

public interface JobSeekerDao extends JpaRepository<JobSeeker, Integer> {
    JobSeeker findById(int Id);

    JobSeeker findByNationalIdentity(String nationalIdentity);
}
