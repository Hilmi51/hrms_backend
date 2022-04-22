package hrms.hrms_backend.dataacceess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrms_backend.entities.concretes.PreliminaryExplanation;

public interface PreliminaryExplanationDao extends JpaRepository<PreliminaryExplanation, Integer> {
    List<PreliminaryExplanation> findAllByCv_Id(int id);
}
