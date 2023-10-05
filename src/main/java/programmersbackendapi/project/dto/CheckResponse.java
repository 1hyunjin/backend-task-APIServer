package programmersbackendapi.project.dto;

import lombok.Data;
import lombok.Getter;


public class CheckResponse {

    private String message;

    public CheckResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
