package hrms.hrms_backend.core.utilities.image.adapters.abstracts;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

public interface CloudinaryUploadService {
    Map<String, Object> upload(MultipartFile file);
}
