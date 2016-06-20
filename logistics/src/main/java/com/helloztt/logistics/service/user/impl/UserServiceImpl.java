package com.helloztt.logistics.service.user.impl;

import com.helloztt.logistics.entity.author.User;
import com.helloztt.logistics.repository.user.UserRepository;
import com.helloztt.logistics.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by helloztt on 2016/6/20.
 */
@Service
public class UserServiceImpl implements UserService,UserDetailsService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findByUserName(username);
        if(user == null){
            throw  new UsernameNotFoundException("用户名不存在！");
        }
        return user;
    }

    @Override
    public void addUser(User user) {

    }

    @Override
    public User findByUserName(String userName) {
        return userRepository.findByUsername(userName);
    }
}
