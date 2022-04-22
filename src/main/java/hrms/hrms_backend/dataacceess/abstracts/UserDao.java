package hrms.hrms_backend.dataacceess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrms_backend.entities.concretes.User;

public interface UserDao extends JpaRepository<User, Integer> {
    User findByUserEmail(String email);

    User findById(int id);
}
