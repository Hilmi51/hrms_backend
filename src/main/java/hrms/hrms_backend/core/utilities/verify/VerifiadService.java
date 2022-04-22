package hrms.hrms_backend.core.utilities.verify;

public interface VerifiadService {

    void sendVerificationCode(String email);

    String codeGenerator();
}
