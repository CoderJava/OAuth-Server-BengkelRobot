package com.hendisantika.service.user;

import com.hendisantika.db.user.User;

import java.util.List;

public interface UserService {

    User save(User user);

    List<User> findAll();

    User findUserByUsername(String username);

    void delete(long id);
}
