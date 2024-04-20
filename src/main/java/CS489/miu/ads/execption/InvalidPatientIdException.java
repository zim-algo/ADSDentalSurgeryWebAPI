package CS489.miu.ads.execption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidPatientIdException extends RuntimeException {

    public InvalidPatientIdException(String message){
        super(message);
    }
}
