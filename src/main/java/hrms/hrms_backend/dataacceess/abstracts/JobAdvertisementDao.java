package hrms.hrms_backend.dataacceess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import hrms.hrms_backend.entities.concretes.JobAdvertisement;


public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {
    @Query("From JobAdvertisement where isActive=true")
    List<JobAdvertisement> findByIsActive();

    JobAdvertisement findById(int advertisement);
}
