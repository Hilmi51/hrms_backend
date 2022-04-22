package hrms.hrms_backend.core.utilities.verify;

import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class VerifiadManager implements VerifiadService {

    @Override
    public void sendVerificationCode(String email) {

        UUID uuid = UUID.randomUUID();
        String verificatitionLink = "https://hrmsverifiademail/" + uuid.toString();
    }

    @Override
    public String codeGenerator() {

        UUID uuid = UUID.randomUUID();
        String verificationCode = uuid.toString();
        return verificationCode;
    }

}
