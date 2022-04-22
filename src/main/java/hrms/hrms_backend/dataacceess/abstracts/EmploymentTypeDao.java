package hrms.hrms_backend.dataacceess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrms_backend.entities.concretes.EmploymentType;


public interface EmploymentTypeDao extends JpaRepository<EmploymentType, Integer> {

}
