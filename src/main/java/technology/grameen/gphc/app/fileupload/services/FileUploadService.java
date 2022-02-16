package technology.grameen.gphc.app.fileupload.services;

import org.springframework.web.multipart.MultipartFile;
import technology.grameen.gphc.app.fileupload.response.UploadResponse;

public interface FileUploadService {

    UploadResponse storeFile(MultipartFile file);


}
