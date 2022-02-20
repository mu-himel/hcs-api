package technology.grameen.gphc.app.response;

import java.util.Optional;

public class SimpleResponse {

    private Integer status;
    private Optional<?> obj;
    private String message;

    public SimpleResponse(){}

    public SimpleResponse(Integer status, Optional<?> obj, String message) {
        this.status = status;
        this.obj = obj;
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Optional<?> getObj() {
        return obj;
    }

    public void setObj(Optional<?> obj) {
        this.obj = obj;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
