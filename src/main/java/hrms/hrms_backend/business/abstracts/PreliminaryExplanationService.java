package hrms.hrms_backend.business.abstracts;

import java.util.List;

import hrms.hrms_backend.core.utilities.result.DataResult;
import hrms.hrms_backend.core.utilities.result.Result;
import hrms.hrms_backend.entities.concretes.PreliminaryExplanation;

public interface PreliminaryExplanationService {

    DataResult<List<PreliminaryExplanation>> getAllByCvId(int cvId);

    DataResult<List<PreliminaryExplanation>> getAll();

    Result add(PreliminaryExplanation preliminaryExplanation);

    Result update(PreliminaryExplanation preliminaryExplanation);

    Result delete(PreliminaryExplanation preliminaryExplanation);
}
