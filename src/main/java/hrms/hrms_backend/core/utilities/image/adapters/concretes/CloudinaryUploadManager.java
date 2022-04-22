package hrms.hrms_backend.core.utilities.image.adapters.concretes;

import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import hrms.hrms_backend.core.utilities.image.adapters.abstracts.CloudinaryUploadService;
import hrms.hrms_backend.core.utilities.image.adapters.cloudinary.CloudinaryUpload;

@Service
public class CloudinaryUploadManager implements CloudinaryUploadService {

    @Override
    public Map<String, Object> upload(MultipartFile file) {
        CloudinaryUpload cloudinaryUpload = new CloudinaryUpload();
        Map<String, Object> uploadResult = cloudinaryUpload.upload(file);
        return uploadResult;
    }

}
