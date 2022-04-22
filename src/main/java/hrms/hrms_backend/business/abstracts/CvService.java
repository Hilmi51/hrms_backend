package hrms.hrms_backend.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import hrms.hrms_backend.core.utilities.result.DataResult;
import hrms.hrms_backend.core.utilities.result.Result;
import hrms.hrms_backend.entities.concretes.Cv;

public interface CvService {
    DataResult<List<Cv>> getAll();

    DataResult<List<Cv>> getAllByJobSeekerId(int jobSeekerId);

    DataResult<String> uploadImage(int id, MultipartFile file);

    Result add(Cv cv);

    Result update(Cv cv);

    Result delete(Cv cv);
}
