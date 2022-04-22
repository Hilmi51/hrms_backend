package hrms.hrms_backend.dataacceess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrms_backend.entities.concretes.VerifiedCode;

public interface VerifiedCodeDao extends JpaRepository<VerifiedCode, Integer> {
    VerifiedCode findByUserIdAndVerificationCode(int userId, String verificationCode);
}
