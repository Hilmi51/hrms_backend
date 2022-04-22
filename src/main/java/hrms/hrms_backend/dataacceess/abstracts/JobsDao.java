package hrms.hrms_backend.dataacceess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrms_backend.entities.concretes.Jobs;


public interface JobsDao extends JpaRepository<Jobs, Integer> {
    Jobs findByExplanation(String explanation);
}
