package hrms.hrms_backend.dataacceess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrms_backend.entities.concretes.Cv;


public interface CvDao extends JpaRepository<Cv, Integer> {
    List<Cv> findByJobSeeker_id(int id);
}
