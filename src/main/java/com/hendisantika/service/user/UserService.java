package com.hendisantika.service.user;

import com.hendisantika.db.user.User;

import java.util.List;

public interface UserService {

    User save(User user);

    List<User> findAll();

    void delete(long id);
}
