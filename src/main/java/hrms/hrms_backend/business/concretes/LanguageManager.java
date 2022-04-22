package hrms.hrms_backend.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrms_backend.business.abstracts.LanguageService;
import hrms.hrms_backend.core.utilities.result.DataResult;
import hrms.hrms_backend.core.utilities.result.Result;
import hrms.hrms_backend.core.utilities.result.SuccessDataResult;
import hrms.hrms_backend.core.utilities.result.SuccessResult;
import hrms.hrms_backend.dataacceess.abstracts.LanguageDao;
import hrms.hrms_backend.entities.concretes.Language;

@Service
public class LanguageManager implements LanguageService {

    private LanguageDao languageDao;

    @Autowired
    public LanguageManager(LanguageDao languageDao) {
        super();
        this.languageDao = languageDao;
    }

    @Override
    public DataResult<List<Language>> getAllByCvId(int jobSeekerId) {
        return new SuccessDataResult<List<Language>>(
                this.languageDao.findAllByCv_Id(jobSeekerId)
        );
    }

    @Override
    public DataResult<List<Language>> getAll() {
        return new SuccessDataResult<List<Language>>(
                this.languageDao.findAll()
        );
    }

    @Override
    public Result add(Language language) {
        this.languageDao.save(language);
        return new SuccessResult("Language added... ");
    }

    @Override
    public Result update(Language language) {
        this.languageDao.save(language);
        return new SuccessResult("Language updated... ");
    }

    @Override
    public Result delete(Language language) {
        this.languageDao.delete(language);
        return new SuccessResult("Language deleted... ");
    }
}
