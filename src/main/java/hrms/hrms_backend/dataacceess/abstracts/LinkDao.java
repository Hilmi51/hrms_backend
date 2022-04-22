package hrms.hrms_backend.dataacceess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrms_backend.entities.concretes.Link;

public interface LinkDao extends JpaRepository<Link, Integer> {
    List<Link> findAllByCv_Id(int id);
}
