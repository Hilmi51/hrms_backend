package hrms.hrms_backend.business.abstracts;

import java.util.List;

import hrms.hrms_backend.core.utilities.result.DataResult;
import hrms.hrms_backend.core.utilities.result.Result;
import hrms.hrms_backend.entities.concretes.JobAdvertisement;

public interface JobAdvertisementService {

    DataResult<List<JobAdvertisement>> getByIsActive();

    DataResult<List<JobAdvertisement>> getAllSortedByReleaseDate();

    DataResult<List<JobAdvertisement>> getAll();

    Result enableAdmin(int adminId);

    Result changeVerifiedByAdmin(int adminId);

    Result add(JobAdvertisement jobAdvertisement);

    Result update(JobAdvertisement jobAdvertisement);

    Result delete(JobAdvertisement jobAdvertisement);
}
