package com.hendisantika.controller.register;

import com.hendisantika.db.user.User;
import com.hendisantika.model.data.base.Diagnostic;
import com.hendisantika.model.docs.user.DocsUser;
import com.hendisantika.service.user.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Register", description = "REST API for Register User", tags = "Register")
@RestController
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private UserService userService;

    @ApiOperation(
            value = "Register a user",
            notes = "Register a user to login oauth",
            response = DocsUser.class,
            responseContainer = "DocsUser",
            produces = "application/json"
    )
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> create(@RequestBody User user) {
        Map<String, Object> mapDataReturn = new HashMap<>();
        Diagnostic diagnostic = new Diagnostic();
        boolean isFieldValid = true;
        if (user.getUsername().isEmpty()) {
            isFieldValid = false;
            diagnostic.setMessage("Field username is required");
        } else if (user.getPassword().isEmpty()) {
            isFieldValid = false;
            diagnostic.setMessage("Field password is required");
        } else if (user.getAge() == 0) {
            isFieldValid = false;
            diagnostic.setMessage("Field age cannot zero");
        }
        if (!isFieldValid) {
            diagnostic.setStatus(HttpStatus.BAD_REQUEST.value());
            mapDataReturn.put("diagnotic", diagnostic);
            return new ResponseEntity<>(mapDataReturn, HttpStatus.BAD_REQUEST);
        }
        User userLocal = userService.findUserByUsername(user.getUsername());
        if (userLocal != null) {
            diagnostic.setMessage("Username already exists. Please use another username.");
            diagnostic.setStatus(HttpStatus.BAD_REQUEST.value());
            mapDataReturn.put("diagnostic", diagnostic);
            return new ResponseEntity<>(mapDataReturn, HttpStatus.BAD_REQUEST);
        }
        User userResult = userService.save(user);
        diagnostic.setStatus(HttpStatus.CREATED.value());
        diagnostic.setMessage(HttpStatus.CREATED.name());
        mapDataReturn.put("diagnostic", diagnostic);
        return new ResponseEntity<>(mapDataReturn, HttpStatus.CREATED);
    }

}
