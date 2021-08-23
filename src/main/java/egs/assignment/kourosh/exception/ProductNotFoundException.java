package egs.assignment.kourosh.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ProductNotFoundException extends Throwable {
    public ProductNotFoundException() {
    }

    public ProductNotFoundException(java.lang.String message) {
        super(message);
    }

    public ProductNotFoundException(java.lang.String message, java.lang.Throwable cause) {
        super(message, cause);
    }

    public ProductNotFoundException(java.lang.Throwable cause) {
        super(cause);
    }

    public ProductNotFoundException(java.lang.String message, java.lang.Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
