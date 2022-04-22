package hrms.hrms_backend.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import hrms.hrms_backend.business.abstracts.CvService;
import hrms.hrms_backend.core.utilities.image.adapters.abstracts.CloudinaryUploadService;
import hrms.hrms_backend.core.utilities.result.DataResult;
import hrms.hrms_backend.core.utilities.result.ErorDataResult;
import hrms.hrms_backend.core.utilities.result.Result;
import hrms.hrms_backend.core.utilities.result.SuccessDataResult;
import hrms.hrms_backend.core.utilities.result.SuccessResult;
import hrms.hrms_backend.dataacceess.abstracts.CvDao;
import hrms.hrms_backend.entities.concretes.Cv;

@Service
public class CvManager implements CvService {

    private CvDao cvDao;
    private CloudinaryUploadService cloudinaryUploadService;

    @Autowired
    public CvManager(CvDao cvDao, CloudinaryUploadService cloudinaryUploadService) {
        super();
        this.cvDao = cvDao;
        this.cloudinaryUploadService = cloudinaryUploadService;
    }

    @Override
    public DataResult<List<Cv>> getAll() {
        return new SuccessDataResult<List<Cv>>(
                this.cvDao.findAll()
        );
    }

    @Override
    public DataResult<List<Cv>> getAllByJobSeekerId(int jobSeekerId) {
        return new SuccessDataResult<List<Cv>>(
                this.cvDao.findByJobSeeker_id(jobSeekerId)
        );
    }

    @Override
    public DataResult<String> uploadImage(int id, MultipartFile file) {
        if (!file.getContentType().toString().startsWith("image")) {
            return new ErorDataResult<String>(
                    "Failed to load photo! The file is not an image.", file.getContentType()
            );
        } else if (!this.cvDao.existsById(id)) {
            return new ErorDataResult<String>(
                    "Failed to load photo! Not found curriculum vitae.", null
            );
        } else {
            String secure_url = this.cloudinaryUploadService.upload(file).get("secure_url").toString();
            Cv cv = this.cvDao.findById(id).get();
            cv.setImageLink(secure_url);
            this.cvDao.save(cv);
            return new SuccessDataResult<String>(
                    "Photo uploadad ! ", secure_url
            );
        }
    }

    @Override
    public Result add(Cv cv) {
        this.cvDao.save(cv);
        return new SuccessResult("Cv added");
    }

    @Override
    public Result update(Cv cv) {
        this.cvDao.save(cv);
        return new SuccessResult("Cv updated");
    }

    @Override
    public Result delete(Cv cv) {
        this.cvDao.delete(cv);
        return new SuccessResult("Cv deleted");
    }
}
