package hrms.hrms_backend.core.utilities.image.adapters.cloudinary;

import java.io.IOException;
import java.util.Map;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import org.springframework.web.multipart.MultipartFile;

public class CloudinaryUpload {

    @SuppressWarnings("unchecked")
    public Map<String, Object> upload(MultipartFile file) {
        Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "hrmsdemo",
                "api_key", "635127775344211",
                "api_secret", "VT6SQEdS-PrVw5nXBFHoSwxyjgs"));
        try {
            @SuppressWarnings("rawtypes")
            Map params = ObjectUtils.asMap(
                    "folder", "cv/photos/",
                    "public_id", null,
                    "overwrite", true,
                    "notification_url", null,
                    "resource_type", "image"
            );

            Map<String, Object> uploadResult = cloudinary.uploader().upload(file.getBytes(), params);
            return uploadResult;
        } catch (IOException h) {
            h.printStackTrace();
        }
        return ObjectUtils.emptyMap();
    }
}
