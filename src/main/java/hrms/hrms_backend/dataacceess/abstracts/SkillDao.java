package hrms.hrms_backend.dataacceess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrms_backend.entities.concretes.Skill;

public interface SkillDao extends JpaRepository<Skill, Integer> {
    List<Skill> findAllByCv_Id(int id);
}
