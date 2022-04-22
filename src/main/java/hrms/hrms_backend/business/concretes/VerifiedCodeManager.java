package hrms.hrms_backend.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrms_backend.business.abstracts.VerifiedCodeService;
import hrms.hrms_backend.core.utilities.result.DataResult;
import hrms.hrms_backend.core.utilities.result.SuccessDataResult;
import hrms.hrms_backend.core.utilities.result.SuccessResult;
import hrms.hrms_backend.dataacceess.abstracts.VerifiedCodeDao;
import hrms.hrms_backend.core.utilities.result.Result;
import hrms.hrms_backend.entities.concretes.VerifiedCode;

@Service
public class VerifiedCodeManager implements VerifiedCodeService {

    private VerifiedCodeDao verifiedCodeDao;

    @Autowired
    public VerifiedCodeManager(VerifiedCodeDao verifiedCodeDao) {
        super();
        this.verifiedCodeDao = verifiedCodeDao;
    }

    @Override
    public DataResult<VerifiedCode> getByUserIdAndVerificationCode(int userId, String verificationCode) {
        return new SuccessDataResult<VerifiedCode>(
                this.verifiedCodeDao.findByUserIdAndVerificationCode(userId, verificationCode)
        );
    }

    @Override
    public Result add(VerifiedCode verifiedCode) {
        this.verifiedCodeDao.save(verifiedCode);
        return new SuccessResult("Code added... ");
    }

    @Override
    public Result update(VerifiedCode verifiedCode) {
        this.verifiedCodeDao.save(verifiedCode);
        return new SuccessResult("Code updated... ");
    }

    @Override
    public Result delete(VerifiedCode verifiedCode) {
        this.verifiedCodeDao.save(verifiedCode);
        return new SuccessResult("Code deleted... ");
    }

}
