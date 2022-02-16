package technology.grameen.gphc.app.fileupload.exception;

public class FileUploaderException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public FileUploaderException(String message) {
        super(message);
    }

    public FileUploaderException(String message, Throwable cause) {
        super(message, cause);
    }
}
