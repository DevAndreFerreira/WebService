package br.com.estudo.webservice.service.impl;

import br.com.estudo.webservice.model.request.UserDetailsRequestModel;
import br.com.estudo.webservice.model.response.UserRest;
import br.com.estudo.webservice.service.UserService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private Map<String, UserRest> users;

    @Override
    public UserRest createUser(UserDetailsRequestModel userDetails) {
        UserRest returnValue = new UserRest();
        returnValue.setFirstName(userDetails.getFirstName());
        returnValue.setLastName(userDetails.getLastName());
        returnValue.setPassword(userDetails.getPassword());
        returnValue.setEmail(userDetails.getEmail());
        String userId = UUID.randomUUID().toString();
        returnValue.setUserId(userId);
        if(users == null) users = new HashMap<>();
        users.put(userId, returnValue);

        return returnValue;
    }

}
