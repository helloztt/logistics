package com.helloztt.logistics.service.user;

import com.helloztt.logistics.entity.author.User;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Created by helloztt on 2016/6/20.
 */
public interface UserService extends UserDetailsService {

    String addUser(User user);

    User findByUserName(String userName);
}
