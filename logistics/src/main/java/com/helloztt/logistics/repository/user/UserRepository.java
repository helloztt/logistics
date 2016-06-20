package com.helloztt.logistics.repository.user;

import com.helloztt.logistics.entity.author.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * Created by helloztt on 2016/6/20.
 */
@Repository
public interface UserRepository extends JpaRepository<User,Integer>,JpaSpecificationExecutor<User> {

    User findByUsername(String userName);
}
