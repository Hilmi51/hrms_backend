package hrms.hrms_backend.dataacceess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrms_backend.entities.concretes.Employees;


public interface EmployeesDao extends JpaRepository<Employees, Integer> {
    Employees findById(int id);
}
