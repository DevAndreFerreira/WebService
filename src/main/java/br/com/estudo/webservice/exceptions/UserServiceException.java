package br.com.estudo.webservice.exceptions;

public class UserServiceException extends RuntimeException{

    private static final long serialVersionUID = 193839292L;

    public UserServiceException(String message) {
        super(message);
    }

}
