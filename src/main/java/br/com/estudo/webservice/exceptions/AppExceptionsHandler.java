package br.com.estudo.webservice.exceptions;

import br.com.estudo.webservice.GeralErroDto;
import br.com.estudo.webservice.model.response.ErrorMessage;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ControllerAdvice
public class AppExceptionsHandler extends ResponseEntityExceptionHandler {

   @ExceptionHandler(value = {Exception.class})
   public ResponseEntity<Object> handleAnyException(Exception ex, WebRequest request) {

       String errorMessageDescription = ex.getLocalizedMessage();
       if(errorMessageDescription == null) errorMessageDescription = ex.toString();
       ErrorMessage errorMessage = new ErrorMessage(new Date(), errorMessageDescription);
       return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);

   }

    @ExceptionHandler(value = {NullPointerException.class, UserServiceException.class})
    public ResponseEntity<Object> handleSpecificExceptions(Exception ex, WebRequest request) {

        String errorMessageDescription = ex.getLocalizedMessage();
        if(errorMessageDescription == null) errorMessageDescription = ex.toString();
        ErrorMessage errorMessage = new ErrorMessage(new Date(), errorMessageDescription);
        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(final MethodArgumentNotValidException ex, final HttpHeaders headers, final HttpStatus status, final WebRequest request) {
        final List<String> errors = new ArrayList<String>();
        GeralErroDto geralErroDto = new GeralErroDto();
        for (final FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.add(error.getField() + ": " + error.getDefaultMessage());
        }
        geralErroDto.setErrors(errors);
        return new ResponseEntity<>(geralErroDto, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

}
