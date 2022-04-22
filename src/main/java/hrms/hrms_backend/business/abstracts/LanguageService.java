package hrms.hrms_backend.business.abstracts;

import java.util.List;

import hrms.hrms_backend.core.utilities.result.DataResult;
import hrms.hrms_backend.core.utilities.result.Result;
import hrms.hrms_backend.entities.concretes.Language;

public interface LanguageService {

    DataResult<List<Language>> getAllByCvId(int cvId);

    DataResult<List<Language>> getAll();


    Result add(Language language);

    Result update(Language language);

    Result delete(Language language);
}
