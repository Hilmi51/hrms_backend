package hrms.hrms_backend.business.abstracts;

import java.util.List;

import hrms.hrms_backend.core.utilities.result.DataResult;
import hrms.hrms_backend.core.utilities.result.Result;
import hrms.hrms_backend.entities.concretes.Skill;

public interface SkillService {

    DataResult<List<Skill>> getAllByCvId(int cvId);

    DataResult<List<Skill>> getAll();

    Result add(Skill skill);

    Result update(Skill skill);

    Result delete(Skill skill);
}
