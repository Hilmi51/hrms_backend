package hrms.hrms_backend.dataacceess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrms_backend.entities.concretes.School;

public interface SchoolDao extends JpaRepository<School, Integer> {
    List<School> findAllByCv_Id(int id);
}
