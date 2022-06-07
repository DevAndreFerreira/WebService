package br.com.estudo.webservice.controller;

import br.com.estudo.webservice.exceptions.UserServiceException;
import br.com.estudo.webservice.model.request.UpdateUserDetailRequestModel;
import br.com.estudo.webservice.model.request.UserDetailsRequestModel;
import br.com.estudo.webservice.model.response.UserRest;
import br.com.estudo.webservice.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


@RestController
@RequestMapping("users")
public class UserController {

    private Map<String, UserRest> users;

    @Autowired
    private UserServiceImpl userService;

    @GetMapping(path = "/{userId}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<UserRest> getUser(@PathVariable String userId) {

        if(true) throw new UserServiceException("A user service exception is thrown");

        if(users.containsKey(userId)) {
            return new ResponseEntity<UserRest>(users.get(userId), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping
    public String getUsers(@RequestParam(value = "page", defaultValue = "1") Integer page,
                           @RequestParam(value = "limit", defaultValue = "1",required = false) Integer limit,
                           @RequestParam(value = "sort", required = false) Integer sort) {
        return "Get user was called with page = " + page + " limit " + limit + " sort " + sort;
    }

    @PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE,
                              MediaType.APPLICATION_JSON_VALUE},
                produces = {  MediaType.APPLICATION_XML_VALUE,
                              MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsRequestModel userDetails) {
        UserRest user = userService.createUser(userDetails);
        return new ResponseEntity<UserRest>(user, HttpStatus.OK);
    }

    @PutMapping(path = "/{userId}",
            consumes = {
                      MediaType.APPLICATION_XML_VALUE,
                      MediaType.APPLICATION_JSON_VALUE},
            produces = {
                      MediaType.APPLICATION_XML_VALUE,
                      MediaType.APPLICATION_JSON_VALUE})
    public UserRest updateUser(@PathVariable String userId, @RequestBody UpdateUserDetailRequestModel userDetails) {
        UserRest storedUserDetails = users.get(userId);
        storedUserDetails.setFirstName(userDetails.getFirstName());
        storedUserDetails.setLastName(userDetails.getLastName());
        users.put(userId, storedUserDetails);
        return storedUserDetails;
    }

    @DeleteMapping(path = "/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable String userId) {
        users.remove(userId);
        return ResponseEntity.noContent().build();
    }

}
