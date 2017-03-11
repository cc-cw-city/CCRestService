package uk.ac.city.cc.dto;

/**
 * Created by santiagoginzburg on 11/03/2017.
 */
public class ServiceResponse {

    private String message;

    public ServiceResponse(final String msg) {
        this.message = msg;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
