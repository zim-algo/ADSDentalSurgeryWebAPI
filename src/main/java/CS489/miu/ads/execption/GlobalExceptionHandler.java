package CS489.miu.ads.execption;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {NotElementFoundException.class})
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(NotElementFoundException e){
        var errorResponse = new ErrorResponse(
                e.getMessage(),
                ZonedDateTime.now(ZoneId.of("Z")));

        return new ResponseEntity(errorResponse, HttpStatus.NOT_FOUND);

    }


      @ExceptionHandler(NoResourceFoundException.class)
      public ResponseEntity<ErrorResponse> handleNoResourceFoundException(NoResourceFoundException ex) {
            var errorResponse = new ErrorResponse(
                    "Invalid resource",
                    ZonedDateTime.now(ZoneId.of("Z")));
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
       }


}
