package javaguide.ems.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus( value = HttpStatus.NOT_FOUND)
// One of the most common usages of the @ResponseStatus annotation is
// attaching it directly to exception classes. This means that whenever
// the exception is thrown within the application,
// Spring MVC will automatically return the designated HTTP status
// code.
public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String message) {
        super(message);
        // send the message to super class basically parent class
        // which has some implementation
    }
}
