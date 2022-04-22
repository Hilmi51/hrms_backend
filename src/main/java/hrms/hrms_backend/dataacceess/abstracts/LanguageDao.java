package hrms.hrms_backend.dataacceess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrms_backend.entities.concretes.Language;

public interface LanguageDao extends JpaRepository<Language, Integer> {
    List<Language> findAllByCv_Id(int id);
}
