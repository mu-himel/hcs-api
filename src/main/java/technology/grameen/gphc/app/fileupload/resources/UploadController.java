package technology.grameen.gphc.app.fileupload.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import technology.grameen.gphc.app.fileupload.response.UploadResponse;
import technology.grameen.gphc.app.fileupload.services.FileUploadService;

@RestController
@RequestMapping("/api/v1/file-upload")
public class UploadController {

    @Autowired
    private FileUploadService fileUploadService;

    @PostMapping("/upload/{type}")
    public ResponseEntity<UploadResponse> upload(@PathVariable String type,@RequestParam MultipartFile file){
        String path = "";
        if(type.equalsIgnoreCase("profile")){
            path = "profiles";
        }else if (type.equalsIgnoreCase("doc")){
            path = "documents";
        }else{
            path = "sites";
        }

        return new ResponseEntity<>(
                fileUploadService.storeFile(file,path),
                HttpStatus.OK
        );
    }

}
