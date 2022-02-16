package technology.grameen.gphc.app.fileupload.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import technology.grameen.gphc.app.fileupload.exception.FileUploaderException;
import technology.grameen.gphc.app.fileupload.property.FileUploadProperty;
import technology.grameen.gphc.app.fileupload.response.UploadResponse;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.UUID;

@Service
public class FileUploadServiceImpl implements FileUploadService{

    private final Path fileLocation;

    @Autowired
    public FileUploadServiceImpl(FileUploadProperty properties){
        this.fileLocation = Paths.get(properties.getUploadDir())
                .toAbsolutePath().normalize();

        try {
            Files.createDirectories(this.fileLocation);
        }catch (Exception ex){
            throw new FileUploaderException("Could not create directory where the uploaded file will be stored.", ex);
        }
    }



    @Override
    public UploadResponse storeFile(MultipartFile file) {



        try{
            Files.createDirectories(this.fileLocation);
        } catch (Exception e) {
            throw new FileUploaderException("Sorry! Could not create directory");
        }

        String fileOriginalName = file.getOriginalFilename();
        byte[] byteVal = (String.valueOf(Instant.now().getEpochSecond())+ fileOriginalName).getBytes();
        UUID uuid = UUID.nameUUIDFromBytes(byteVal);
        String fileName = uuid.toString()+"."+fileOriginalName.substring(fileOriginalName.lastIndexOf('.')+1);

        try{
            if(fileName.contains("..")){
                throw new FileUploaderException("Sorry! File Contains Invalid Path "+ fileName);
            }

            Path targetLocation = fileLocation.resolve(fileName);
            Files.copy(file.getInputStream(),targetLocation);

            return new UploadResponse(fileName, file.getContentType(),file.getSize());
        } catch (IOException ex){
            throw new FileUploaderException("Sorry! Could not upload "+ fileName + ". PLease try again later.");
        }
    }
}
