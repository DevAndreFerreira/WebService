package br.com.estudo.webservice.model.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class UpdateUserDetailRequestModel {

    @NotNull(message = "First name cannot by null")
    private String firstName;
    @NotNull(message = "Last name cannot by null")
    private String lastName;

}
