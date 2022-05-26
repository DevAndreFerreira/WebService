package br.com.estudo.webservice.controller;

import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("users")
public class UserController {

    @GetMapping(path = "/{userId}")
    public String getUser(@PathVariable String userId) {
        return "Get user was called with = " + userId;
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
