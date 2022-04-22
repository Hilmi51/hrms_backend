package hrms.hrms_backend.dataacceess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrms_backend.entities.concretes.City;

public interface CityDao extends JpaRepository<City, Integer> {
    City findByCityName(String name);

    City findById(int id);
}
