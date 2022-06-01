package br.com.estudo.webservice.model.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class UserDetailsRequestModel {

    private String userId;

    @NotNull(message = "First name cannot by null")
    private String firstName;
    @NotNull(message = "Last name cannot by null")
    private String lastName;
    @NotNull(message = "Email name cannot by null")
    @Email
    private String email;
    @NotNull(message = "Password name cannot by null")
    @Size(min = 8, max = 16, message = "Password must be equal or grater than 8 characters and less than 16 characters")
    private String password;

}
