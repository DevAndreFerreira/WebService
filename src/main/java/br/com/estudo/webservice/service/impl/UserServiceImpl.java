package br.com.estudo.webservice.service.impl;

import br.com.estudo.webservice.model.request.UserDetailsRequestModel;
import br.com.estudo.webservice.model.response.UserRest;
import br.com.estudo.webservice.service.UserService;
import br.com.estudo.webservice.shared.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    private Map<String, UserRest> users;
    private Utils utils;

    @Autowired
    public UserServiceImpl(Utils utils) {
        this.utils = utils;
    }

    @Override
    public UserRest createUser(UserDetailsRequestModel userDetails) {
        UserRest returnValue = new UserRest();
        returnValue.setFirstName(userDetails.getFirstName());
        returnValue.setLastName(userDetails.getLastName());
        returnValue.setPassword(userDetails.getPassword());
        returnValue.setEmail(userDetails.getEmail());
        String userId = utils.generatedUserIDd();
        returnValue.setUserId(userId);
        if(users == null) users = new HashMap<>();
        users.put(userId, returnValue);

        return returnValue;
    }

}
