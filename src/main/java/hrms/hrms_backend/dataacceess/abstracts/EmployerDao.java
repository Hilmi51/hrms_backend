package hrms.hrms_backend.dataacceess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrms_backend.entities.concretes.Employer;


public interface EmployerDao extends JpaRepository<Employer, Integer> {
    Employer findById(int id);

    Employer findByEmployerEmail(String email);
}
