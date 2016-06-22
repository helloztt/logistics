package com.helloztt.logistics.repository.user;

import com.helloztt.logistics.entity.author.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * Created by helloztt on 2016/6/22.
 */
@Repository
public interface MenuRepository extends JpaSpecificationExecutor<Menu>,JpaRepository<Menu,Integer> {
}
