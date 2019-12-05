package com.hendisantika.controller.user;

import com.hendisantika.db.user.User;
import com.hendisantika.model.data.base.Diagnostic;
import com.hendisantika.model.docs.diagnostic.DocsDiagnostic;
import com.hendisantika.model.docs.user.DocsUser;
import com.hendisantika.model.docs.user.DocsUserCollection;
import com.hendisantika.service.user.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "User", description = "REST API for User", tags = "User")
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(
            value = "Collection of user",
            notes = "Collection of all user from database",
            response = DocsUserCollection.class,
            responseContainer = "DocsUserCollection",
            produces = "application/json"
    )
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> listUser() {
        List<User> listUserTemp = userService.findAll();
        List<com.hendisantika.model.data.user.User> listUser = new ArrayList<>();
        for (User item : listUserTemp) {
            com.hendisantika.model.data.user.User userData = new com.hendisantika.model.data.user.User(
                    item.getUsername(),
                    item.getAge()
            );
            listUser.add(userData);
        }
        Map<String, Object> mapDataReturn = new HashMap<>();
        Diagnostic diagnostic = new Diagnostic();
        if (listUser.isEmpty()) {
            diagnostic.setStatus(HttpStatus.NO_CONTENT.value());
            diagnostic.setMessage(HttpStatus.NO_CONTENT.name());
        } else {
            diagnostic.setStatus(HttpStatus.OK.value());
            diagnostic.setMessage(HttpStatus.OK.name());
        }
        mapDataReturn.put("diagnostic", diagnostic);
        mapDataReturn.put("users", listUser);
        return new ResponseEntity<>(mapDataReturn, HttpStatus.OK);
    }

    /*@ApiOperation(
            value = "Delete a user",
            notes = "Delete a user from login oauth",
            response = DocsDiagnostic.class,
            responseContainer = "DocsDiagnostic",
            produces = "application/json"
    )
    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Map<String, Object>> delete(@PathVariable(value = "id") Long id) {
        Diagnostic diagnostic = new Diagnostic();
        Map<String, Object> mapDataReturn = new HashMap<>();
        userService.delete(id);
        diagnostic.setStatus(HttpStatus.OK.value());
        diagnostic.setMessage(HttpStatus.OK.name());
        mapDataReturn.put("diagnostic", diagnostic);
        return new ResponseEntity<>(mapDataReturn, HttpStatus.OK);
    }*/

}
