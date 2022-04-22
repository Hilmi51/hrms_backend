package hrms.hrms_backend.business.abstracts;

import hrms.hrms_backend.core.utilities.result.DataResult;
import hrms.hrms_backend.core.utilities.result.Result;
import hrms.hrms_backend.entities.concretes.VerifiedCode;

public interface VerifiedCodeService {

    DataResult<VerifiedCode> getByUserIdAndVerificationCode(int userId, String verificationCode);

    Result add(VerifiedCode verifiedCode);

    Result update(VerifiedCode verifiedCode);

    Result delete(VerifiedCode verifiedCode);
}
