package br.com.estudo.webservice.controller;

import br.com.estudo.webservice.model.response.UserRest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("users")
public class UserController {

    @GetMapping(path = "/{userId}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public UserRest getUser(@PathVariable String userId) {
        UserRest userRest = new UserRest();
        userRest.setUserId(userId);
        userRest.setFirstName("André");
        userRest.setLastName("Ferreira de Paula");
        userRest.setEmail("andreferreira0@gmail.com");
        return userRest;
    }
    @GetMapping
    public String getUsers(@RequestParam(value = "page", defaultValue = "1") Integer page,
                           @RequestParam(value = "limit", defaultValue = "1",required = false) Integer limit,
                           @RequestParam(value = "sort", required = false) Integer sort) {
        return "Get user was called with page = " + page + " limit " + limit + " sort " + sort;
    }

    @PostMapping
    public String createUser() {
        return "Create user was called";
    }

    @PutMapping
    public String updateUser() {
        return "Update user was called";
    }

    @DeleteMapping
    public String deleteUser() {
        return "Delete user was called";
    }

}
