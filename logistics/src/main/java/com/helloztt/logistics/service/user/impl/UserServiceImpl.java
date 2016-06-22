package com.helloztt.logistics.service.user.impl;

import com.helloztt.logistics.entity.author.User;
import com.helloztt.logistics.repository.user.UserRepository;
import com.helloztt.logistics.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by helloztt on 2016/6/20.
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findByUserName(username);
        if(user == null){
            throw  new UsernameNotFoundException("用户名不存在！");
        }
        return user;
    }

    @Override
    @Transactional
    public String addUser(User user) {
        //判断用户名是否存在
        User existUserName = findByUserName(user.getUsername());
        if(existUserName != null){
            return "用户名已存在！";
        }
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return null;
    }

    @Override
    public User findByUserName(String userName) {
        return userRepository.findByUsername(userName);
    }
}
