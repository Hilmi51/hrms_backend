package hrms.hrms_backend.business.abstracts;

import java.util.List;

import hrms.hrms_backend.core.utilities.result.DataResult;
import hrms.hrms_backend.core.utilities.result.Result;
import hrms.hrms_backend.entities.concretes.Link;

public interface LinkService {

    DataResult<List<Link>> getAllByCvId(int cvId);

    DataResult<List<Link>> getAll();

    Result add(Link link);

    Result update(Link link);

    Result delete(Link link);
}
