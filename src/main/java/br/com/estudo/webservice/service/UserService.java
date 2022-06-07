package br.com.estudo.webservice.service;

import br.com.estudo.webservice.model.request.UserDetailsRequestModel;
import br.com.estudo.webservice.model.response.UserRest;

public interface UserService {
    UserRest createUser(UserDetailsRequestModel userDetails);
}
