package br.com.estudo.webservice.model.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRest {

    private String firstName;
    private String lastName;
    private String email;
    private String userId;

}
