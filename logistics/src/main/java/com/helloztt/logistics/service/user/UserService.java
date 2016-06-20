package com.helloztt.logistics.service.user;

import com.helloztt.logistics.entity.author.User;

/**
 * Created by helloztt on 2016/6/20.
 */
public interface UserService {

    void addUser(User user);

    User findByUserName(String userName);
}
